package com.udea.ejemplo.persistencia.implementacion;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.persistencia.RepositorioUsuarioJPA;
import com.udea.ejemplo.persistencia.mapeador.MapeoUsuario;
import com.udea.ejemplo.persistencia.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioEnMemoria implements RepositorioUsuario {
    @Autowired
    private RepositorioUsuarioJPA repositorioUsuario;
    @Autowired
    private MapeoUsuario mapeoUsuario;

    @Override
    public void guardar(Usuario usuario) {
        repositorioUsuario.save(mapeoUsuario.usuarioAEntidad(usuario));
    }

    @Override
    public List<Usuario> listar() {
        return mapeoUsuario.listaEntidadAUsuario(repositorioUsuario.findAll());
    }
}
