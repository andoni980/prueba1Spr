package com.ipartek.spring.prueba1Spr.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.spring.prueba1Spr.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

	@Query("SELECT l from Libro l")
	Iterable<Libro> getLibrosSinAutores();
	
	Iterable<Libro> findByTituloContains(String titulo);
}
