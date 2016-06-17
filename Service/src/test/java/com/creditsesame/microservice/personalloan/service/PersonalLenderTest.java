package com.creditsesame.microservice.personalloan.service;

import com.creditsesame.microservice.personalloan.dao.PersonalLenderDao;
import com.creditsesame.microservice.personalloan.domain.PersonalLender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by francisco on 4/7/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonalLenderTest {

    @InjectMocks
    private PersonalLenderService personalLenderService;

    @Mock
    private PersonalLenderDao customerDao;

    @Test
    public void getCustomerById_success(){
        when(customerDao.getById(1L)).thenReturn(new PersonalLender());
        PersonalLender personalLender = personalLenderService.getCustomerById(1L);
        Assert.assertNotNull(personalLender);
        verify(customerDao, times(1)).getById(any(Long.class));
    }

}