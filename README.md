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

#### Client microservice modules
This is just proposal as I think that we should have a naming convention for this.

*Client classes: com.creditsesame.microservice.##NameMicroservice##.client##Version##

**ie. com.creditsesame.microservice.personalloan.clientV1

*Client proto classes: com.creditsesame.microservice.##NameMicroservice##.protobuf

**ie. com.creditsesame.microservice.personalloan.protobuf

#### Service microservice modules
*Service classes: com.creditsesame.microservice.##NameMicroservice##.##component##

**ie. com.creditsesame.microcervice.personalloan.controller

**ie. com.creditsesame.microcervice.personalloan.dao

**ie. com.creditsesame.microcervice.personalloan.service

**ie. com.creditsesame.microcervice.personalloan.springconf -> configuration of spring

## Why the client should be provided, PROS AND CONS DISCUSSION

PROS:
- Creating the client is a way to ensure the contract

- More testing ensured by the team creating the api

- Backward compatibility better ensured too

- It looks just natural for protocol buffers

- Possibility of adding mock functionality in the client library itself that allows the cosumer to work in a offline mode

- Better understanding on what the API delivers even without reading documentation

- There is some extra work that could seem to be some overhead but actually taking into account that we have the compromise of coming with a good set of tests, the creation of the client should not be seen as extra work in this context but just part of the integration testing suite

- Forcing devs to create clients and run tests through the clients, we enforce them to care about backward compatibitily


CONS:
- Would just be available for a Java consumer, if the languaje chosen is different then the client will need be implemented in their side.

- Exceeding in the abstraction can lead to bad practices in programing of the consumer, as the fact that the client is calling a webservice is not that clear at first glance to the developers

- As the same team creates both the server and client library there is the possibility that some of the logic could leak into the client, which is something to avoid.



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