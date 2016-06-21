package com.creditsesame.personalloan.clientV1;

import com.creditsesame.microservice.personalloan.protobuf.PersonalLenderProtos;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;


/** COMMENTS IN THIS CLASS ARE INTENDED TO EXPLAIN THE ROLE OF THE CLASS IN THE ARCHITECTURE AND CLARIFY WHAT HAS NOT BEEN COVERED
    BUT SHOULD BE COVERED WHEN USING THIS TO PROGRAM A REAL SERVICE

    This class is supposed to be taken as a model to create lightweight clients although at this moment this is still
    lacking some more pieces that should be there in the future. ie.
     - Analysis of the response code to see if everything goes good before trying to parse the body
     - Evaluate if it would be necessary a better management of exceptions if the client get a error http code or a
       error message in the body
     - Configurable management (in property files) of the url of the service and the port, a setter method has been provided to
       port as it is used by integrationTests in the service
     - All the items before could be provided in a super class that all the client classes inherit so the management of http response
       codes, exceptions and the url and port is already inherited by any client and we avoid code repetition.
     - Mock mode of the client. The mock could be in a different class, Spring has ways to configure the injection of one class
       or another depending on a value. Mock mode should be configured though property.
       This would be a very useful feature to make it easier to the consumer to do their unit tests and development without
       relying on services that are somewhere else in the network.
     - Logs, no log is printed right now, this is definitely necessary when calling another service. At bare minimum the usertoken
       and transaction id of the call should be printed
*/
@Component
//@Profile(Profiles)
public class PersonalLoanLenderClient {

    /**
        This value will need to be parameterized
     */
    //@Value("service.url")
    private final String urlService = "http://local.creditsesame.com";

    /**
        This value should also be parameterized
     */
    //@Value("service.port")
    private int urlPort = 8080;

    /**
        This method shows how to make a GET call from the client, this is still missing some support, for instance the
        transaction id should probably be send either in the body or in the header of the http message
        Also a better support of Exceptions is missing and some checking of the http code returned
     */
    public PersonalLenderProtos.PersonalLender callForPersonalLenderById(long id) throws IOException{
        /**
            A better building of the url should be provided, the url should be put in a super class as it would
            be common to every client class and the resources can be packed in a enum ideally and also have a better
            replacement of the path params
         */
        String resource = urlService + ":" + urlPort + "/personallender/" + id;
        final Response response = RestAssured.get(resource);
        return PersonalLenderProtos.PersonalLender.parseFrom(response.getBody().asInputStream());
    }

    /**
        This method shows how to store a new lender using protobuf. This method would still need to be completed with the
        same pieces described in the method above
     */
    public PersonalLenderProtos.PersonalLender updateOrInsertPersonalLender(PersonalLenderProtos.PersonalLender personalLender) throws IOException{
        String resource = urlService + ":" + urlPort + "/personallender/";
        byte[] byteArray = personalLender.toByteArray();
        final Response response = RestAssured.given().contentType("application/x-protobuf").body(byteArray).post(resource);
        return PersonalLenderProtos.PersonalLender.parseFrom(response.getBody().asInputStream());
    }

    /**
        Setter method for the port is provided to
     */
    public void setUrlPort(int urlPort) {
        this.urlPort = urlPort;
    }
}
