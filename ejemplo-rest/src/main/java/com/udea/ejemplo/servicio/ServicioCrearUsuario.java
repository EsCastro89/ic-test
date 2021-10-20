package com.udea.ejemplo.servicio;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.persistencia.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public void ejecutar(Usuario usuario) {
        repositorioUsuario.guardar(usuario);
    }
}
