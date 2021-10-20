package com.udea.ejemplo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Usuario implements Serializable {
    private Long id;
    private String nombre;
    private String identificacion;
}
