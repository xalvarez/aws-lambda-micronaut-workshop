#!/bin/sh
docker build . -t aws-lambda-micronaut-workshop
mkdir -p build
docker run --rm --entrypoint cat aws-lambda-micronaut-workshop  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000

