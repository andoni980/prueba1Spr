package com.ipartek.spring.prueba1Spr.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.spring.prueba1Spr.entidades.Libro;
import com.ipartek.spring.prueba1Spr.servicios.AdminService;
import com.ipartek.spring.prueba1Spr.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("libros", usuarioService.getLibros());
		return "index";
	}
	
	@GetMapping("{id}")
	public String detalleLibroPorId(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("libro", usuarioService.getLibroById(id).get());
//		modelo.addAttribute("autor", usuarioService.getAutorByLibroId(id).get());
//		System.out.println(modelo.getAttribute("autor").toString());
		return "detalle-libro";
	}
	
//	@GetMapping("{titulo}")
//	public String detalleLibroPorTitulo(Model modelo, @PathVariable("titulo") String titulo) {
//		modelo.addAttribute("libro", usuarioService.getLibrosByTituloContains(titulo));
//		return "detalle-libro";
//	}
	
	@GetMapping("autores")
	public String autores(Model modelo) {
		modelo.addAttribute("autores", usuarioService.getAutores());
		return "autores";
	}
	
//	@GetMapping("autores/{id}")
//	public String detalleAutorPorId(Model modelo, @PathVariable("id") Long id) {
//		modelo.addAttribute("autor", usuarioService.getAutorById(id));
//		return "detalle-autor";
//	}
	
//	@GetMapping("autores/{nombre}")
//	public String detalleAutorPorNombre(Model modelo, @PathVariable("nombre") String nombre) {
//		modelo.addAttribute("autor", usuarioService.getAutoresByNombreContains(nombre));
//		return "detalle-autor";
//	}
	
	@GetMapping("admin")
	public String adminLibros(Libro libro) {
		libro.setTitulo("");
		return "admin";
	}
	
	@PostMapping("admin")
	public String adminLibroPost(@Valid Libro libro, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			return "admin";
		}
		
		adminService.saveLibro(libro);
		
		return "redirect:/";
	}
}
