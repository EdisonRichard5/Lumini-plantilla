package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Servicio;
import com.clean.app.web.reporting.LlaveValor;

public interface IServicioService {
	public void save(Servicio servicio);
	
	public Servicio findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Servicio> findAll();

	public List<LlaveValor> countServicio(Integer id);
}
