package com.clean.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "SERVICIO")
public class Servicio implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDSERVICIO")
	private Integer idservicio;
	
	@Column(name="TIPO")
	@Size(max=20)
	private String tipo;
	
	@Column(name="PRECIO")
	private float precio ;
	
	@JsonIgnore
	@OneToMany(mappedBy="master", fetch=FetchType.LAZY)
	private List<Pedido> pedido;

	public Servicio() {
		super();
	}
	
	public Servicio(Integer id) {
		super();
		this.idservicio=id;
	}
	
	public Integer getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
}
