package com.springjpa.estudandospringjpa.services;

import com.springjpa.estudandospringjpa.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends  AbstractEmailService{

    private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);


    @Override
    public void sendEmail(SimpleMailMessage msg) {

        LOG.info("Simulando envio de email ...");
        LOG.info(msg.toString());
        LOG.info("E-mail enviado");
    }
}
