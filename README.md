# AWS Lambda Micronaut Workshop

This project contains an AWS Lambda featuring
[Micronaut](https://micronaut.io/),
[GraalVM](https://www.graalvm.org/) and
[Serverless](https://serverless.com/).

The Lambda implements the following REST endpoints:

* `/ping`, which returns an example response body
* `/capital/{country}`, which uses the REST Countries API to retrieve a country's capital

This material is part of a workshop and a blog entry.

## Deployment

Before deploying the application for the first time, Serverless needs to be installed:

    npm install

The application can be built and deployed as follows:

    ./deploy.sh

As a result, an API Gateway will be created containing an endpoint which allows to call our Lambda,
e.g.:

    curl https://abcde.execute-api.eu-central-1.amazonaws.com/dev/capital/germany
