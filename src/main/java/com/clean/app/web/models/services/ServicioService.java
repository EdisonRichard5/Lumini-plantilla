package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IServicio;
import com.clean.app.web.models.entities.Servicio;

@Service
public class ServicioService implements IServicioService{
	@Autowired //Inyeccion de dependencia
	private IServicio dao;
	@Override
	@Transactional
	public void save(Servicio servicio) {
		// TODO Auto-generated method stub
		dao.save(servicio);
	}

	@Override
	@Transactional(readOnly=true)
	public Servicio findById(Integer id) {
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
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>) dao.findAll();
	}

}
