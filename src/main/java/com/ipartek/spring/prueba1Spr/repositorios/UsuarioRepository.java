package com.ipartek.spring.prueba1Spr.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.spring.prueba1Spr.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}