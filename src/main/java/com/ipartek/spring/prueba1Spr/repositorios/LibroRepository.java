package com.ipartek.spring.prueba1Spr.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.spring.prueba1Spr.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

	Iterable<Libro> findByTituloContains(String titulo);
}
