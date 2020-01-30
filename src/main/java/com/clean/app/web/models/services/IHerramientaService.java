package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Herramienta;

public interface IHerramientaService {
	public void save(Herramienta herramienta);
	
	public Herramienta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Herramienta> findAll();
}
