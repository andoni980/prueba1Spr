package com.ipartek.spring.prueba1Spr.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

@Entity
@Table(name = "autores")
public class Autor {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank(message = "El nombre es un campo obligatorio")
	@Size(min=3, max=150)
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull(message = "El email es un dato obligatorio")
	@Email
	private String email; 
	
//	@OneToMany(mappedBy = "autor")
//	private Set<Libro> libros;
}
