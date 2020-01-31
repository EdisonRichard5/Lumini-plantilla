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
	public void save(Master master) {
		try{
			dao.save(master);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public Master findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
	
		dao.deleteById(id);
	}

	@Override
	public List<Master> findAll() {
		return (List<Master>) dao.findAll();
	}


	@Override
	public List<Master> findByCliente(Integer id) {
		return dao.findByCliente(id);
	}
}
