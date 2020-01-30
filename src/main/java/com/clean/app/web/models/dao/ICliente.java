package com.clean.app.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clean.app.web.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer> {

}
