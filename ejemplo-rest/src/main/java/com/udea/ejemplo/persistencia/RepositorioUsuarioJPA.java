package com.udea.ejemplo.persistencia;

import com.udea.ejemplo.persistencia.entidad.EntidadUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJPA extends CrudRepository<EntidadUsuario,Long> {
}
