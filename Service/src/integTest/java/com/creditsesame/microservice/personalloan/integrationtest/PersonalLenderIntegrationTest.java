package com.creditsesame.microservice.personalloan.integrationtest;

import com.creditsesame.SkeletonServiceProjectApplication;
import com.creditsesame.microservice.personalloan.protobuf.PersonalLenderProtos;
import com.creditsesame.personalloan.clientV1.PersonalLoanLenderClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
   This is an example of integration test to test the API provided in the microservice. Note the next things:
    - It is in a different folder than the 'standard' test folder, this is done in purpose as I don't want it to be run
      in the 'build' gradle lifecycle and I want to give the flexibility to run it on demand
    - It is using to call the API the CLIENT class provided in the client project, this also done in purpose to test the
      integration through the library that is going to be provided to consumer.

    VERY IMPORTANT TO TAKE INTO ACCOUNT:
    - Any client library previously generated that is still supported should have its own test to ensure that everything keeps
      going good (Backward compatibility)
    - If a new release of the server remove the support of any of the previous libraries, then the tests created to ensure the
      compatibility of that client library should be removed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkeletonServiceProjectApplication.class)
@WebAppConfiguration
@Profile(value = "inttest")
@IntegrationTest("server.port:0")
public class PersonalLenderIntegrationTest {

    @Value("${local.server.port}")
    protected int port;

    @Autowired
    private PersonalLoanLenderClient personalLoanLenderClient;

    @Before
    public void setup(){
        personalLoanLenderClient.setUrlPort(port);
    }

    /**
        The integration test checks the endpoint through the client, the same client that is going to be used by
        other parties.
        If we support other former client versions, we should have integration tests for every version that we support
        so we can certify the backward compatibility and that a new release of the service does not break the consumer
        while they are not updated yet to the new client version.

        Obviously this test should do much more assertions on the message recieved
     */
    @Test
    public void testPersonalLenderIntegration() throws Exception{
        PersonalLenderProtos.PersonalLender PersonalLenderResponse =  personalLoanLenderClient.callForPersonalLenderById(1L);
        Assert.assertEquals("AVANT_CREDIT", PersonalLenderResponse.getName());
    }
}
