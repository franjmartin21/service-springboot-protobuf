package com.creditsesame.microservice.personalloan.dao;


import com.creditsesame.microservice.personalloan.domain.PersonalLender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
    Simple Dao class that just uses Spring-jdbc
 */
@Repository
public class PersonalLenderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PersonalLender getById(long id){
        return jdbcTemplate.queryForObject("Select * from PersonalLender where id = " + id,
                new BeanPropertyRowMapper<PersonalLender>(PersonalLender.class));
    }
}
