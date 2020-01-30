package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IProducto;
import com.clean.app.web.models.entities.Producto;

@Service
public class ProductoService implements IProductoService{
	@Autowired //Inyeccion de dependencia
	private IProducto dao;
	@Override
	@Transactional
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer id) {
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
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) dao.findAll();
	}

}
