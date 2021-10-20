package com.udea.ejemplo.persistencia.repositorio;

import com.udea.ejemplo.modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario {

    void guardar(Usuario usuario);

    List<Usuario> listar();
}
