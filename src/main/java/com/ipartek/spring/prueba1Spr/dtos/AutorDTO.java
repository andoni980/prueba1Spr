package com.ipartek.spring.prueba1Spr.dtos;

import java.util.Set;

import com.ipartek.spring.prueba1Spr.entidades.Libro;

public record AutorDTO(Long id, String nombre, String email, Set<Libro> libros ) {

}
