package com.udea.ejemplo.servicio;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.persistencia.mapeador.MapeoUsuario;
import com.udea.ejemplo.persistencia.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioListarUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private MapeoUsuario mapeoUsuario;

    public List<Usuario> ejecutar(){
        return repositorioUsuario.listar();
    }
}
