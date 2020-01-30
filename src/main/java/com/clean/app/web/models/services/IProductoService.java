package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Producto;

public interface IProductoService {
	public void save(Producto producto);
	
	public Producto findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Producto> findAll();
}
