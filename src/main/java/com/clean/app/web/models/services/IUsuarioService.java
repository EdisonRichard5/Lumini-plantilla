package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Usuario;

public interface IUsuarioService {
	public void save(Usuario usuario);
	
	public Usuario findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Usuario> findAll();
}
