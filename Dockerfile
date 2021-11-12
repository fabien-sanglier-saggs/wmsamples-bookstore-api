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

# Optional: ADD license key (good option for a closed secure environment)
COPY --chown=${SAG_USERID}:${SAG_GROUPID} licensing/msr-licenseKey.xml $SAG_HOME/IntegrationServer/config/licenseKey.xml

# copy jdbc jar in jdbc adapter
COPY --chown=${SAG_USERID}:${SAG_GROUPID} libs/postgresql.jar $SAG_HOME/IntegrationServer/packages/WmJDBCAdapter/code/jars/

# copy the package specific settings
COPY --chown=${SAG_USERID}:${SAG_GROUPID} application.properties $SAG_HOME/IntegrationServer/

# copy package(s)
COPY --chown=${SAG_USERID}:${SAG_GROUPID} assets/IS/Packages/BookstoreAPI/ $PACKAGES_DIR/BookstoreAPI/

# run Jcode to build the java code
RUN true \
    && $SAG_HOME/IntegrationServer/bin/jcode.sh make BookstoreAPI \
    && true