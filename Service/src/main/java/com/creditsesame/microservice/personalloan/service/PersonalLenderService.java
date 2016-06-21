package com.creditsesame.microservice.personalloan.service;

import com.creditsesame.microservice.personalloan.dao.PersonalLenderDao;
import com.creditsesame.microservice.personalloan.domain.PersonalLender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
    Normal Service class

    TO BE DONE:
    - Transaction support with Spring transaction?? This needs to be configured in the propagation and isolation required
 */
@Transactional
@Service
public class PersonalLenderService {

    @Autowired
    private PersonalLenderDao personalLenderDao;

    public PersonalLender getCustomerById(long id){
        return personalLenderDao.getById(id);
    }

    public void saveCustomer(Long id, PersonalLender personalLender){
        PersonalLender personalLender1 = getCustomerById(id);
        personalLender.setId(id);
        if(personalLender1 == null)
            personalLenderDao.insertRecord(personalLender);
    }

    public PersonalLender insertCustomer(PersonalLender personalLender){
        if(personalLender == null) return null;

        Long newLender = personalLenderDao.insertRecord(personalLender);
        return getCustomerById(newLender);
    }


}
