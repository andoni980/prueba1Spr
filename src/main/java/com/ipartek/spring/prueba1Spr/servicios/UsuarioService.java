package com.ipartek.spring.prueba1Spr.servicios;

import java.util.Optional;
import java.util.Set;

import com.ipartek.spring.prueba1Spr.dtos.AutorSinLibrosDTO;
import com.ipartek.spring.prueba1Spr.dtos.LibroDTO;
import com.ipartek.spring.prueba1Spr.entidades.Autor;
import com.ipartek.spring.prueba1Spr.entidades.Libro;

public interface UsuarioService {

	Iterable<Libro> getLibros();
	Optional<Libro> getLibroById(Long id);
	Iterable<Libro> getLibrosByTituloContains(String titulo);
	Set<LibroDTO> getLibrosSinAutores();

	
	Iterable<AutorSinLibrosDTO> getAutores();
	Optional<Autor> getAutorById(Long id);
	Iterable<Autor> getAutoresByNombreContains(String nombre);
}
