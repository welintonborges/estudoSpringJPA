package com.springjpa.estudandospringjpa.services;

import com.springjpa.estudandospringjpa.domain.Categoria;
import com.springjpa.estudandospringjpa.domain.Cliente;
import com.springjpa.estudandospringjpa.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido obj) {
        SimpleMailMessage sm = prepareSimpleMessageForPedido(obj);
        sendEmail(sm);
    }

    @Override
    public void sendOrderConfirmationEmail(Categoria obj) {
        SimpleMailMessage sm = prepareSimpleMessageForPedido(obj);
        sendEmail(sm);
    }

    private SimpleMailMessage prepareSimpleMessageForPedido(Pedido obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado! Código: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return  sm;
    }

    private SimpleMailMessage prepareSimpleMessageForPedido(Categoria obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
//        sm.setTo(obj.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado! Código: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return  sm;
    }
}
