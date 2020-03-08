#!/bin/bash
docker build . -t aws-lambda-micronaut-workshop
mkdir -p build
docker run --rm --entrypoint cat aws-lambda-micronaut-workshop  /home/application/function.zip > build/function.zip

npx serverless deploy -v
