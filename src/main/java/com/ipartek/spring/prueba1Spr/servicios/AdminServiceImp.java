package com.ipartek.spring.prueba1Spr.servicios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.spring.prueba1Spr.entidades.Autor;
import com.ipartek.spring.prueba1Spr.entidades.Libro;

@Service
@Primary
public class AdminServiceImp extends UsuarioServiceImp implements AdminService{

	@Override
	public Libro saveLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public Libro updateLibro(Libro libro) {
		libro.setId(null);
		return libroRepository.save(libro);
	}

	@Override
	public void deleteLibro(Long id) {
		libroRepository.deleteById(id);
	}

	@Override
	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor updateAutor(Autor autor) {
		autor.setId(null);
		return autorRepository.save(autor);
	}

	@Override
	public void deleteAutor(Long id) {
		autorRepository.deleteById(id);
	}

}
