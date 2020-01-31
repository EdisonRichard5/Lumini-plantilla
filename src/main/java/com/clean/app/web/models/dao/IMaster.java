package com.clean.app.web.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clean.app.web.models.entities.Master; 

public interface IMaster extends CrudRepository<Master,Integer>  {

	public List<Master> findByCliente(Integer id);
}
