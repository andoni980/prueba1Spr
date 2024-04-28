package com.ipartek.spring.prueba1Spr.servicios;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.prueba1Spr.dtos.AutorSinLibrosDTO;
import com.ipartek.spring.prueba1Spr.dtos.LibroDTO;
import com.ipartek.spring.prueba1Spr.entidades.Autor;
import com.ipartek.spring.prueba1Spr.entidades.Libro;
import com.ipartek.spring.prueba1Spr.repositorios.AutorRepository;
import com.ipartek.spring.prueba1Spr.repositorios.LibroRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	protected LibroRepository libroRepository;
	
	@Autowired
	protected AutorRepository autorRepository;
	
	@Override
	public Iterable<Libro> getLibros() {
		return libroRepository.findAll();
	}

	@Override
	public Optional<Libro> getLibroById(Long id) {
		return libroRepository.findById(id);
	}

	@Override
	public Iterable<Libro> getLibrosByTituloContains(String titulo) {
		return libroRepository.findByTituloContains(titulo);
	}

	@Override
	public Set<AutorSinLibrosDTO> getAutores() {
		Set<AutorSinLibrosDTO> autoresDTOs = new HashSet<>();
		for(Autor a: autorRepository.findAll()) {
			AutorSinLibrosDTO autorDTO = new AutorSinLibrosDTO(a.getId(), a.getNombre(), a.getEmail());
			autoresDTOs.add(autorDTO);
		}
		return autoresDTOs;
	}

	@Override
	public Optional<Autor> getAutorById(Long id) {
		return autorRepository.findById(id);
	}

	@Override
	public Iterable<Autor> getAutoresByNombreContains(String nombre) {
		return autorRepository.findByNombreContains(nombre);
	}

	@Override
	public Set<LibroDTO> getLibrosSinAutores() {
//		System.out.println(libroRepository.getLibrosSinAutores().toString());
//		Set<Libro> libros = libroRepository.getLibrosSinAutores();
		Set<LibroDTO> librosDTOs = new HashSet<>();
		for(Libro l: libroRepository.getLibrosSinAutores()) {
			LibroDTO libroDTO = new LibroDTO(l.getId(), l.getTitulo(), l.getPrecio(), l.getDescuento());
			librosDTOs.add(libroDTO);
		}
		return librosDTOs;
	}

}
