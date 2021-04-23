# OLSS demo application

[![Build & packaging](https://github.com/andreaceccanti/olss-demo-app/actions/workflows/maven_build.yml/badge.svg)](https://github.com/andreaceccanti/olss-demo-app/actions/workflows/maven_build.yml)

## Manual build instructions

The build requires Java 11 sdk installed on your machine.
To build, issue the following command:

```console
./mvnw package
```

## Github actions build

See [here](.github/workflows/maven_build.yml).

## Gitlab CI build

See [here](.gitlab-ci.yml).

## Demo app APIs

The OLSS provides a simple REST api described in this section.

### Actuator API

### GET /actuator/info

Returns information about the app (version, git commit id)

### GET /actuator/health

Returns health status information

### Hello API

#### GET /api/hello

Retutns a gentle hello from the API

### Memory Hog API

#### POST /api/memory/grow

Allocates a 10M heap chunk and returns the memory used by the memory hog.

#### POST /api/memory/clear

Clears the memory chunks and returns the memory used by the memory hog.

### Examples




