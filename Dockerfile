ARG BASE_IMAGE
FROM $BASE_IMAGE as base

LABEL maintainer="fabien.sanglier@softwareaggov.com" \
      name="webMethods Bookstore API" \
      summary="BookStore CRUD API built with webMEthods Microservice Runtime"

# Optional: ADD license key (good option for a closed secure environment)
# But for general distribution though let's not...and have the users map their own license key
# COPY --chown=sagadmin:sagadmin assets/licenses/msr-licenseKey.xml $SAG_HOME/IntegrationServer/config/licenseKey.xml

# copy the package specific settings
COPY --chown=sagadmin:sagadmin assets/IS/configs/application.properties $SAG_HOME/IntegrationServer/
COPY --chown=sagadmin:sagadmin assets/IS/configs/globalVariables.xml $SAG_HOME/IntegrationServer/config/globalVariables.cnf

## copy package(s)
COPY --chown=${SAG_USERID}:${SAG_GROUPID} target/build/IS/BookstoreAPI.zip ${PACKAGES_AUTO_DEPLOY_DIR}/
