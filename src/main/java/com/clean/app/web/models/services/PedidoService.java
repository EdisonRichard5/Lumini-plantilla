package com.clean.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IPedido;
import com.clean.app.web.models.entities.Pedido;

@Service
public class PedidoService implements IPedidoService{
	@Autowired //Inyeccion de dependencia
	private IPedido dao;
	@Override
	@Transactional
	public void save(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.save(pedido);
	}

	@Override
	@Transactional(readOnly=true)
	public Pedido findById(Integer id) {
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
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return (List<Pedido>) dao.findAll();
	}

}
