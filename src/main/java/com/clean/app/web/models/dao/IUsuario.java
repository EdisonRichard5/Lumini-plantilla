package com.clean.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clean.app.web.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{

	public Usuario findByNombre(String nombre);
	
}