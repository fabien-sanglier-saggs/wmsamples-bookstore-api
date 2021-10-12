ARG BASE_IMAGE
FROM $BASE_IMAGE as base

LABEL maintainer="fabien.sanglier@softwareaggov.com" \
      name="webMethods Bookstore API" \
      summary="BookStore CRUD API built with webMEthods Microservice Runtime"

ENV JDBC_HOST=""
ENV JDBC_PORT=""
ENV JDBC_DBNAME=""
ENV JDBC_USERNAME=""
ENV JDBC_USERPASSWORD=""
ENV JDBC_PROPS=""

# default users
ENV BUILTIN_USER_ADMIN_PASSWORD="changeme"
ENV BUILTIN_USER_DEVELOPER_PASSWORD="changeme"
ENV BUILTIN_USER_REPLICATOR_PASSWORD="changeme"

# Optional: ADD license key (good option for a closed secure environment)
# But for general distribution though let's not...and have the users map their own license key
# COPY --chown=${SAG_USERID}:${SAG_GROUPID} assets/licenses/msr-licenseKey.xml $SAG_HOME/IntegrationServer/config/licenseKey.xml

# copy jdbc jar in jdbc adapter
COPY --chown=${SAG_USERID}:${SAG_GROUPID} libs/postgresql.jar $SAG_HOME/IntegrationServer/packages/WmJDBCAdapter/code/jars/

# copy the package specific settings
COPY --chown=${SAG_USERID}:${SAG_GROUPID} application.properties $SAG_HOME/IntegrationServer/

# copy package(s)
## NOTE: copying to the auto-deploy package conflicts with the application-properties which are loaded before...
## COPY --chown=${SAG_USERID}:${SAG_GROUPID} build/IS/BookstoreAPI.zip ${PACKAGES_AUTO_DEPLOY_DIR}/
COPY --chown=${SAG_USERID}:${SAG_GROUPID} build/IS/BookstoreAPI.zip $PACKAGES_DIR/
USER root
RUN true \
    && yum -y install unzip \
    && unzip $PACKAGES_DIR/BookstoreAPI.zip -d $PACKAGES_DIR/BookstoreAPI/ \
    && rm -f $PACKAGES_DIR/BookstoreAPI.zip \
    && chown -R ${SAG_USERID}:${SAG_GROUPID} $PACKAGES_DIR/BookstoreAPI/ \
    && yum remove -y unzip \
    && yum clean all \
    && true
USER ${SAG_USER}