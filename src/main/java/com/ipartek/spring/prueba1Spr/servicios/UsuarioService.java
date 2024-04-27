package com.ipartek.spring.prueba1Spr.servicios;

import java.util.Optional;

import com.ipartek.spring.prueba1Spr.entidades.Autor;
import com.ipartek.spring.prueba1Spr.entidades.Libro;

public interface UsuarioService {

	Iterable<Libro> getLibros();
	Optional<Libro> getLibroById(Long id);
	Iterable<Libro> getLibrosByTituloContains(String titulo);
	Iterable<Libro> getLibrosSinAutores();

	
	Iterable<Autor> getAutores();
	Optional<Autor> getAutorById(Long id);
	Iterable<Autor> getAutoresByNombreContains(String nombre);
}
