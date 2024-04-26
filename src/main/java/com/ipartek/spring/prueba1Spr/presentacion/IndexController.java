package com.ipartek.spring.prueba1Spr.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.spring.prueba1Spr.servicios.UsuarioService;

@Controller
@RequestMapping("/index")
public class IndexController {

	private UsuarioService usuarioService;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("libros", usuarioService.getLibros());
		return "libros";
	}
	
	@GetMapping("/{id}")
	public String detalleLibroPorId(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("libro", usuarioService.getLibroById(id));
		return "detalle-libro";
	}
	
	@GetMapping("/{nombre}")
	public String detalleLibroPorNombre(Model modelo, @PathVariable("nombre") String nombre) {
		modelo.addAttribute("libro", usuarioService.getLibrosByNombreContains(nombre));
		return "detalle-libro";
	}
	
	@GetMapping("/autores")
	public String autores(Model modelo) {
		modelo.addAttribute("autores", usuarioService.getAutores());
		return "autores";
	}
	
	@GetMapping("/autores/{id}")
	public String detalleAutorPorId(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("autor", usuarioService.getAutorById(id));
		return "detalle-autor";
	}
	
	@GetMapping("/autores/{nombre}")
	public String detalleAutorPorNombre(Model modelo, @PathVariable("nombre") String nombre) {
		modelo.addAttribute("autor", usuarioService.getAutoresByNombreContains(nombre));
		return "detalle-autor";
	}
}
