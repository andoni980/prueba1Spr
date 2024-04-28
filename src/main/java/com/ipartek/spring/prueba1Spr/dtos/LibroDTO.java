package com.ipartek.spring.prueba1Spr.dtos;

import java.math.BigDecimal;

public record LibroDTO(Long id, String titulo, BigDecimal precio, Integer descuento) {

}
