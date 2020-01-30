package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Pedido;

public interface IPedidoService {
	public void save(Pedido pedido);
	
	public Pedido findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Pedido> findAll();
}
