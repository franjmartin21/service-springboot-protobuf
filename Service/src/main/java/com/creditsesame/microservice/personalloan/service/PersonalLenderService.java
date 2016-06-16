package com.creditsesame.microservice.personalloan.service;

import com.creditsesame.microservice.personalloan.dao.PersonalLenderDao;
import com.creditsesame.microservice.personalloan.domain.PersonalLender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
    Normal Service class

    TO BE DONE:
    - Transaction support with Spring transaction??
 */
@Service
public class PersonalLenderService {

    @Autowired
    private PersonalLenderDao personalLenderDao;

    public PersonalLender getCustomerById(long id){
        return personalLenderDao.getById(id);
    }
}
