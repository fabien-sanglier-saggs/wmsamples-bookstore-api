# wmsamples-bookstore-api
A sample webMethods project to demonstrate the quick creation of a CRUD API for a fictional Bookstore

## Requirements

### Database JDBC driver

This project leverages a Postgres Database to store data.
As a result, the application needs to make JDBC calls to the backend database.
Instead of storing the JDBC driver in GIT, let's just download the JDBC jar for postgres from https://jdbc.postgresql.org/download.html
And place it in ./assets/sql/postgresql.jar so it can be picked up by the build process and added in the right place downstream.

ie.

```bash
curl https://jdbc.postgresql.org/download/postgresql-42.2.24.jar -o ./libs/postgresql.jar
```

TODO: I will work towards a better way to manage the public JAR dependencies using maven...coming soon.
### License(s)

If you have a license of MSR (which will be required to run the MSR runtime), make sure to download it and add it to the following path:
./assets/licenses/msr-licenseKey.xml
So it can be picked up by the build process and added in the right place downstream.

## Running the project

Review the "docker-compose.yml" file which has the deployment details. 

A simple "up" command will automatically build the images if not already up-to-date, and launch the project:

```bash
docker-compose up -d
```
## Developing/Updating the package

In order to actually develop/update/improve the package, a developer will need webMethods Designer (standard Eclipse with extra webMethods components / perspectives)
More info on how to download and install designer for free at: 
https://tech.forums.softwareag.com/t/guide-to-download-and-install-webmethods-service-designer-free-download/235210

Before starting the env for the first time (ie. upon initial clone), let's make sure the assets are compiled (ie. class files are built).

Run:

```bash
docker run -v "${PWD}/assets/IS/Packages/BookstoreAPI:/opt/softwareag/IntegrationServer/packages/BookstoreAPI:rw" --entrypoint "/opt/softwareag/IntegrationServer/bin/jcode.sh" harbor.saggs.cloud/library/webmethods-msr-art-jdbc:dev-10.7-latest make BookstoreAPI
```

To start the development environment, simply use:

```bash
docker-compose -f docker-localdev.yml up -d
```

And connect your Designer to the "localhost" server on port 5555.

Then, update your code, and all code changes will automatically be tracked by this GIT directory. 
Don't forget to commit your changes.
