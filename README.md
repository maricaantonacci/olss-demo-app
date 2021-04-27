# OLSS demo application

[![Build & packaging](https://github.com/andreaceccanti/olss-demo-app/actions/workflows/maven_build.yml/badge.svg)](https://github.com/andreaceccanti/olss-demo-app/actions/workflows/maven_build.yml)

## Manual build instructions

The build requires Java 11 sdk installed on your machine.
To build, issue the following command:

```console
$ ./mvnw package
```

## Manual docker build instructions

A docker image for the app can be built using the following commands:

```console
$ ./mvnw package
$ docker build --file docker/Dockerfile -t olss-demo-app .
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

### Application state API

#### POST /api/application-state/refuse-traffic

Configures application so that traffic is refused, i.e. the readiness probe
fails.


#### POST /api/application-state/accept-traffic

Configures application so that traffic is accepted, i.e. the readiness probe
succeeds.

#### POST /api/application-state/break

Configures application so that liveness probe fails, i.e. the application is
considered broken.

### Memory Hog API

#### POST /api/memory/grow

Allocates a 10M heap chunk and returns the memory used by the memory hog.

#### POST /api/memory/clear

Clears the memory chunks and returns the memory used by the memory hog.
