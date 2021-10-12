# wmsamples-bookstore-api
A sample webMethods project to demonstrate the quick creation of a CRUD API for a fictional Bookstore

## Requirement

### Database JDBC driver

This project leverages a Postgres Database to store data.
As a result, the application needs to make JDBC calls to the backend database.
Instead of storing the JDBC driver in GIT, let's just download the JDBC jar for postgres from https://jdbc.postgresql.org/download.html
And place it in ./assets/sql/postgresql.jar so it can be picked up by the build process and added in the right place downstream.

ie.

```bash
curl https://jdbc.postgresql.org/download/postgresql-42.2.24.jar -o ./libs/postgresql.jar
```

### License

If you have a license of MSR (which will be required to run the MSR runtime), make sure to download it and add it to the following path:
./assets/licenses/msr-licenseKey.xml
So it can be picked up by the build process and added in the right place downstream.

### Developing the Solution

In order to actually develop the solution, a developer will need webMethods Designer (standard Eclipse with extra webMethods components / perspectives)
More info on how to download and install designer for free at: https://tech.forums.softwareag.com/t/guide-to-download-and-install-webmethods-service-designer-free-download/235210

## Develop the project

```bash
docker-compose -f docker-localdev.yml up -d
```

## Build the wM project

```bash
docker run -v "${PWD}:/src" --env "projectName=wmsamples-bookstore-api" harbor.saggs.cloud/library/webmethods-abe:dev-10.7-latest
```

## Build the docker images

```bash
docker-compose build
```

## Run

```bash
docker-compose up -d
```