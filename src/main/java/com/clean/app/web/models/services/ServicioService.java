 package com.clean.app.web.models.services;

import java.util.List;
import  java.math.BigInteger ;
import  java.util.ArrayList ;
import  java.util.List ;
import  java.util.stream.Collectors ;

import  javax.persistence.EntityManager ;
import  javax.persistence.ParameterMode ;
import  javax.persistence.PersistenceContext ;
import  javax.persistence.StoredProcedureQuery ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clean.app.web.models.dao.IServicio;
import com.clean.app.web.models.entities.Servicio;
import com.clean.app.web.reporting.LlaveValor;
@Service
public class ServicioService implements IServicioService{
	@Autowired //Inyeccion de dependencia
	private IServicio dao;
	

	@PersistenceContext
	private EntityManager em; //Es la instancia de persistencia con la BDD
	
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

	@Override	
	public List<LlaveValor> countServicio(Integer id) {		
		StoredProcedureQuery consulta = em.createStoredProcedureQuery("Reporte");
		consulta.registerStoredProcedureParameter("Id", Integer.class, ParameterMode.IN);
		consulta.setParameter("Id", id);				
		consulta.execute();
		List<Object[]> datos = consulta.getResultList();
		System.out.println(datos);
		return datos.stream()
				.map(r -> new LlaveValor((String)r[1], (BigInteger)r[0]))
				.collect(Collectors.toList());		
	}



}
