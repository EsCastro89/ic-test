package com.udea.ejemplo.persistencia.mapeador;

import com.udea.ejemplo.modelo.Usuario;
import com.udea.ejemplo.persistencia.entidad.EntidadUsuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeoUsuario {
    public Usuario entidadAUsuario(EntidadUsuario entidadUsuario) {
        return new Usuario(entidadUsuario.getId(), entidadUsuario.getNombre(), entidadUsuario.getIdentificacion());
    }

    public EntidadUsuario usuarioAEntidad(Usuario Usuario) {
        return new EntidadUsuario(Usuario.getId(), Usuario.getNombre(), Usuario.getIdentificacion());
    }

    public List<Usuario> listaEntidadAUsuario(Iterable<EntidadUsuario> listaEntidadUsuario) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaEntidadUsuario.forEach(entidadUsuario -> listaUsuarios.add(entidadAUsuario(entidadUsuario)));

        return listaUsuarios;
    }
}
