package com.clean.app.web.models.services;

import java.util.List;

import com.clean.app.web.models.entities.Master; 

public interface IMasterService {
	
	public void save(Master master);
	
	public Master findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Master> findAll();

	public List<Master> findByCliente(Integer id);
}
