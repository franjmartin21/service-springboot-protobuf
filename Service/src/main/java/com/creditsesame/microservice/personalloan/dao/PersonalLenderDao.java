package com.creditsesame.microservice.personalloan.dao;


import com.creditsesame.microservice.personalloan.domain.PersonalLender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
    Simple Dao class that just uses Spring-jdbc
 */
@Repository
public class PersonalLenderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String insertSql =
            "INSERT INTO PersonalLender (name, imageLogoUrl, bullets, rightSideText, aboutText) values (?, ?, ?, ?, ?)";
    private final static String updateSql =
            "UPDATE PersonalLender SET name = ?, imageLogoUrl = ?, bullets = ?, rightSideText = ?, aboutText = ? where id = ?";

    public PersonalLender getById(long id){
        return jdbcTemplate.queryForObject("Select * from PersonalLender where id = " + id,
                new BeanPropertyRowMapper<PersonalLender>(PersonalLender.class));
    }

    public Long insertRecord(PersonalLender personalLender){
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertSql);
                ps.setString(1, personalLender.getName());
                ps.setString(2, personalLender.getImageLogoUrl());
                ps.setString(3, personalLender.getBullets());
                ps.setString(4, personalLender.getRightSideText());
                ps.setString(5, personalLender.getAboutText());
                return ps;
            }
        }, holder);

        return holder.getKey().longValue();
    }

    public void updateRecord(PersonalLender personalLender){
        jdbcTemplate.update(updateSql,
                new Object[]{
                        personalLender.getName(),
                        personalLender.getImageLogoUrl(),
                        personalLender.getBullets(),
                        personalLender.getRightSideText(),
                        personalLender.getAboutText(),
                        personalLender.getId()
                });
    }

}
