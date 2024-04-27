package com.ipartek.spring.prueba1Spr.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ipartek.spring.prueba1Spr.entidades.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	Iterable<Autor> findByNombreContains(String nombre);
	
	@Query("from Autor a join fetch a.libros l where l.id=:id ")
	Optional<Autor> findByLibroId(@Param("id") Long id);
}
