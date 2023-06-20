package com.springjpa.estudandospringjpa.config;

import com.springjpa.estudandospringjpa.services.DBService;
import com.springjpa.estudandospringjpa.services.EmailService;
import com.springjpa.estudandospringjpa.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiaTestDataBase();
        return true;
    }
    @Bean
    public EmailService emailService(){
        return  new MockEmailService();
    }
}
