#!/bin/bash
set -e

GH_USER=${GH_USER:-andreaceccanti}
COMMIT_SHA=$(git rev-parse --short HEAD)

docker build --file docker/Dockerfile -t ${GH_USER}/olss-demo-app:${COMMIT_SHA} .
