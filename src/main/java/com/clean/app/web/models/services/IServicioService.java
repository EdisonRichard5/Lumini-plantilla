package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Servicio;
import com.clean.app.web.reporting.LlaveValor;
import com.clean.app.web.reporting.LlaveValor2;

public interface IServicioService {
	public void save(Servicio servicio);
	
	public Servicio findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Servicio> findAll();

	public List<LlaveValor> countServicio(Integer id);
	
	public List<LlaveValor2> Servicio();
}
