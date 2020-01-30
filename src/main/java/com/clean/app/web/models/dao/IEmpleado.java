package com.clean.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clean.app.web.models.entities.Empleado;

public interface IEmpleado extends CrudRepository<Empleado, Integer>{

}
