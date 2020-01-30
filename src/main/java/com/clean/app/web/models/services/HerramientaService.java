package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IHerramienta;
import com.clean.app.web.models.entities.Herramienta;

@Service
public class HerramientaService implements IHerramientaService {
	@Autowired //Inyeccion de dependencia
	private IHerramienta dao;
	
	@Override
	@Transactional
	public void save(Herramienta herramienta) {
		// TODO Auto-generated method stub
		dao.save(herramienta);
	}

	@Override
	@Transactional(readOnly=true)
	public Herramienta findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Herramienta> findAll() {
		// TODO Auto-generated method stub
		return (List<Herramienta>) dao.findAll();
	}
	
}
