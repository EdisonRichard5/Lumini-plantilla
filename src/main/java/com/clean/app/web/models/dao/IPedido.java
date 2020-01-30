package com.clean.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clean.app.web.models.entities.Pedido;

public interface IPedido extends CrudRepository<Pedido, Integer> {

}
