# MICROSERVICE WITH GRADLE, SPRING-BOOT AND PROTOCOL BUFFERS

## Quickstart
*Clone the project: git clone <<url-clone>>

*Build the project: ./gradlew build

*Deploy the project: ./gradlew runBoot

## Basic Structure of the project
*service-springboot-protobuf -> Root of the project

*service-springboot-protobuf/build.gradle -> parent build script of gradle

*service-springboot-protobuf/settings.gradle -> settings file of gradle for the project

**Client -> Module of the project that is going to have the code for the client of the service, it will generare a .jar that should be included as dependency of any consumer

**Client /build.gradle -> build gradle script of module Client

**Client /src -> Folder that contains the source code

**Client /src/java -> Contains the java source code

**Client /generated-src -> This folder contains the generated .java generated from the .proto files, this is not version controlled for obvious reasons.

**Client /build -> Contains .class files and is not version controlled, it is generated by the ./gradle build lifecycle

**Service -> Module of the project that is going to have the code for the service itself, it has as a dependency the Client module

**Service /build.bradle -> build gradle script of module Service

**Service /src -> Contains the source code of the service project

**Service /src/main -> java code of the service

**Service /src/test -> unit test suite of the project

**Service /src/integTest -> Integration test for the service



## Package naming convention used



## Why the client should be provided, PROS AND CONS DISCUSSION


## Naming convention


## Database connection


## Environment support


## SQL script management


## Metrics provided by spring boot


## Evolving API, model proposed


## Unit Tests


## Integration Tests


## Integration Tests and Backward compatibility




## PENDING SUPPORT: Artifact naming convention