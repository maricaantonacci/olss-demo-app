#!/bin/bash
set -e

IMAGE_REPO_NAME=${IMAGE_REPO_NAME:-andreaceccanti}
COMMIT_SHA=$(git rev-parse --short HEAD)

docker build --file docker/Dockerfile -t ${IMAGE_REPO_NAME}/olss-demo-app:${COMMIT_SHA} .
