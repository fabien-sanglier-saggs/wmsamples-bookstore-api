# wmsamples-bookstore-api
A sample webMethods project to demonstrate the quick creation of a CRUD API for a fictional Bookstore

## Requirement

Download JDBC jar for postgres: https://jdbc.postgresql.org/download.html
And place in ./sql/postgresql.jar

## Build the project

```bash
docker run -v "${PWD}:/src"  --env "projectName=wmsamples-bookstore-api" harbor.saggs.cloud/library/webmethods-abe:10.7-latest-local
```

## Build the docker image

```bash
docker run -v "${PWD}:/src"  --env "projectName=wmsamples-bookstore-api" harbor.saggs.cloud/library/webmethods-abe:10.7-latest-local
```