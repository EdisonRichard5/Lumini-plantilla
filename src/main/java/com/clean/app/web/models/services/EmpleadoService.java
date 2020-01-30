package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IEmpleado;
import com.clean.app.web.models.entities.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired //Inyeccion de dependencia
	private IEmpleado dao;
	
	@Override
	@Transactional
	public void save(Empleado empleado) {
		// TODO Auto-generated method stub
		dao.save(empleado);
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Integer id) {
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
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) dao.findAll();
	}

}
