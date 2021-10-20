package com.udea.ejemplo.controlador;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.servicio.ServicioCrearUsuario;
import com.udea.ejemplo.servicio.ServicioListarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    private ServicioCrearUsuario servicioCrearUsuario;
    @Autowired
    private ServicioListarUsuario servicioListarUsuario;

    @PostMapping
    public void crearUsuario(@RequestBody Usuario usuario){
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        servicioCrearUsuario.ejecutar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario(){
        return servicioListarUsuario.ejecutar();
    }
}
