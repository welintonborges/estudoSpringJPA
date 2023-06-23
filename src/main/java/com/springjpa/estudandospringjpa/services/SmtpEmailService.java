package com.springjpa.estudandospringjpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService{



    private MailSender mailSender;

    private static Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {

        LOG.info("Simulando envio de email ...");
        LOG.info(msg.toString());
        mailSender.send(msg);
        LOG.info("E-mail enviado");



    }
}
