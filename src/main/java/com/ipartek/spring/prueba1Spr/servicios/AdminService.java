package com.ipartek.spring.prueba1Spr.servicios;

import com.ipartek.spring.prueba1Spr.entidades.Autor;
import com.ipartek.spring.prueba1Spr.entidades.Libro;

public interface AdminService {

	Libro saveLibro(Libro libro);
	Libro updateLibro(Libro libro);
	void deleteLibro(Long id);
	
	Autor saveAutor(Autor autor);
	Autor updateAutor(Autor autor);
	void deleteAutor(Long id);
}
