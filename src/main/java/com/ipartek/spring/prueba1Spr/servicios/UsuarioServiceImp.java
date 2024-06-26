package com.ipartek.spring.prueba1Spr.servicios;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Iterable<Autor> getAutores() {
//		Set<AutorSinLibrosDTO> autoresDTOs = new HashSet<>();
//		for(Autor a: autorRepository.findAll()) {
//			AutorSinLibrosDTO autorDTO = new AutorSinLibrosDTO(a.getId(), a.getNombre(), a.getEmail());
//			autoresDTOs.add(autorDTO);
//		}
		return autorRepository.findAll();
	}

	@Override
	public Optional<Autor> getAutorById(Long id) {
		return autorRepository.findById(id);
	}

	@Override
	public Iterable<Autor> getAutoresByNombreContains(String nombre) {
		return autorRepository.findByNombreContains(nombre);
	}



}
