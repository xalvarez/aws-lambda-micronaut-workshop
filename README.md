# AWS Lambda Micronaut Workshop

This project contains an AWS Lambda featuring
[Micronaut](https://micronaut.io/),
[GraalVM](https://www.graalvm.org/),
[Serverless](https://serverless.com/) and
[GitHub's GraphQL API](https://developer.github.com/v4/).

The Lambda implements the following REST endpoints:

* `/ping`, which returns an example response body
* `/hello-github`, which uses GitHub's GraphQL API to retrieve a GitHub user's
    username and respond "Hello <username>!"

This material is part of a workshop and an blog entry.
