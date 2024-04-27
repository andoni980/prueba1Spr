package com.ipartek.spring.prueba1Spr.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.spring.prueba1Spr.entidades.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	Iterable<Autor> findByNombreContains(String nombre);
	
}
