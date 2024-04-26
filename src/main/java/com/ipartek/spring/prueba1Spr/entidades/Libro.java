package com.ipartek.spring.prueba1Spr.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El nombre es obligatorio")
	@Size(min = 2, max = 150)
	@Column(name = "nombre")
	private String nombre;

	@NotNull(message = "El precio es un dato obligatorio")
	@Min(0)
	@DecimalMax("2")
	@Column(name = "precio")
	private BigDecimal precio;

	@NotNull(message = "El descuento es un dato oblidatorio")
	@Min(0)
	@Max(100)
	@Column(name = "descuento")
	@Builder.Default
	private Integer descuento = 0;

	@Column(name = "url_foto")
	private String urlFoto;
	
	@NotNull(message = "El ISBN es un dato obligatorio")
	@Pattern(regexp = "^\\d{13}$", message = "Debe tener 13 caracteres")
	private String isbn;
	
//	@NotNull
//	@ManyToOne
//	private Autor autor;

}
