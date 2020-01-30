package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IMaster;
import com.clean.app.web.models.entities.Master; 


@Service
public class MasterService implements IMasterService {
	@Autowired //Inyeccion de dependencia
	private IMaster dao;
	@Override
	@Transactional
	public void save(Master master) {
		// TODO Auto-generated method stub
		dao.save(master);
	}

	@Override
	@Transactional(readOnly=true)
	public Master findById(Integer id) {
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
	public List<Master> findAll() {
		// TODO Auto-generated method stub
		return (List<Master>) dao.findAll();
	}


	@Override
	public List<Master> findByCliente(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByCliente(id);
	}
}
