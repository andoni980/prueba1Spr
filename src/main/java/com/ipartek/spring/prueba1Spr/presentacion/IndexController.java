package com.ipartek.spring.prueba1Spr.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.spring.prueba1Spr.entidades.Autor;
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
//		System.out.println(modelo.getAttribute("libros").toString());
		return "index";
	}
	
	@GetMapping("{id}")
	public String detalleLibroPorId(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("libro", usuarioService.getLibroById(id).get());
		return "detalle-libro";
	}
	
//	@GetMapping("{titulo}")
//	public String detalleLibroPorTitulo(Model modelo, @PathVariable("titulo") String titulo) {
//		modelo.addAttribute("libro", usuarioService.getLibrosByTituloContains(titulo));
//		return "detalle-libro";
//	}
	
	@GetMapping("autores")
	public String autores(Model modelo) {
		Iterable<Autor> autores = usuarioService.getAutores();
		modelo.addAttribute("autores", autores);
		System.out.println(autores);
		System.out.println(autores.iterator().next().getLibros());
//		System.out.println(modelo.getAttribute("autores").toString());
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
	public String adminLibros(Libro libro, Model modelo) {
		modelo.addAttribute("libros", usuarioService.getLibros());
		modelo.addAttribute("autores", usuarioService.getAutores());
		libro.setTitulo("");
		return "admin";
	}
	
	@PostMapping("admin")
	public String adminLibroPost(@Valid Libro libro, BindingResult bindingResult, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("libros", usuarioService.getLibros());
			System.out.println(bindingResult.toString());
			return "admin";
		}
		adminService.saveLibro(libro);
		
		return "redirect:/admin";
	}
	
	@GetMapping("admin/{id}")
	public String adminUpdateLibros(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("libros", usuarioService.getLibros());
		Libro libro = usuarioService.getLibroById(id).get();
		modelo.addAttribute("libro", libro);
		modelo.addAttribute("autores", usuarioService.getAutores());
		return "admin";
	}
	
	@PostMapping("admin/{id}")
	public String adminLibroPost(@Valid Libro libro, BindingResult bindingResult, Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("autores", usuarioService.getAutores());
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("libros", usuarioService.getLibros());
			System.out.println(bindingResult.toString());
			return "admin";
		}
		adminService.updateLibro(libro);
		
		return "redirect:/admin";
	}
	
	@GetMapping("admin/borrar/{id}")
	public String deleteLibro(@PathVariable("id") Long id) {
		adminService.deleteLibro(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
