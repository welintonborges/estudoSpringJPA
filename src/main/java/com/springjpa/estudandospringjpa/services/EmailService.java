package com.springjpa.estudandospringjpa.services;


import com.springjpa.estudandospringjpa.domain.Categoria;
import com.springjpa.estudandospringjpa.domain.Cliente;
import com.springjpa.estudandospringjpa.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);
    void sendOrderConfirmationEmail(Categoria cliente);


    void sendEmail(SimpleMailMessage msg);

}
