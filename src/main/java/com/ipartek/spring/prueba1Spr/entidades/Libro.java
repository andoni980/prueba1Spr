package com.ipartek.spring.prueba1Spr.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El título es obligatorio")
	@Size(min = 2, max = 150)
	@Column(name = "titulo")
	private String titulo;

	@NotNull(message = "El precio es un dato obligatorio")
	@Min(0)
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
	@Pattern(regexp = "^\\d{13}$", message = "Debe tener 13 digitos")
	@Column(name = "isbn", columnDefinition = "CHAR(13)")
	private String isbn;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor_id")
	private Autor autor;

}
