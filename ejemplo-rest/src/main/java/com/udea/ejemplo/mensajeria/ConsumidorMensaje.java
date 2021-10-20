package com.udea.ejemplo.mensajeria;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.servicio.ServicioCrearUsuario;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorMensaje {
    @Autowired
    private ServicioCrearUsuario servicioCrearUsuario;

    // @RabbitListener(queues = "user.queue")
    public void leerMensajeUsuarios(Usuario usuario) {
        System.out.println("DLQ -> Recibio mensaje: {}" + usuario.toString());
        servicioCrearUsuario.ejecutar(usuario);
    }
}
