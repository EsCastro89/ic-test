package com.udea.ejemplo.mensajeria;

import com.udea.ejemplo.modelo.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PublicadorMensajes {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PublicadorMensajes(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //Cada minuto
    // @Scheduled(cron="0 */1 * * * ?")
    public void sendOrder() {
        Usuario usuaro = new Usuario(null, "Usuario 1", "12345");
        this.rabbitTemplate.convertAndSend("user.exchange", "user.routingkey", usuaro);
        System.out.println("Mensaje Enviado");
    }
}
