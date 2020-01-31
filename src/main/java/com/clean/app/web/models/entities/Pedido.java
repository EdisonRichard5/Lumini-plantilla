package com.clean.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


import org.springframework.data.annotation.Transient;

@Entity()
@Table(name = "PEDIDO")
public class Pedido implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPEDIDO")
	private Integer idpedido;
	
	 
	
	@Column(name="COSTEFINAL")
 
	private float costefinal;
	 
	
	@JsonIgnore
	@JoinColumn(name="IDPRODUCTO",referencedColumnName="IDPRODUCTO")
	@ManyToOne
	private Producto producto;
	
	
	@JoinColumn(name="IDSERVICIO",referencedColumnName="IDSERVICIO")
	@ManyToOne
	private Servicio tipoServicio;
	
	
	
	@JoinColumn(name="IDEMPLEADO",referencedColumnName="IDEMPLEADO")
	@ManyToOne
	private Empleado empleado;
	
	/*@JoinColumn(name="IDMASTER",referencedColumnName="IDMASTER")
	@ManyToOne
	private Master master;
	
	*/
	@Transient
	private Integer tipoexamenid;

	
	public Integer getTipoexamenid() {
		return tipoexamenid;
	}

	public void setTipoexamenid(Integer tipoexamenid) {
		this.tipoexamenid = tipoexamenid;
	}

	public Pedido() {
		super();
	}

	public Pedido(Integer id) {
		super();
		this.idpedido = id;
	}
	 

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

 
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	 
	public Servicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Servicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

 
	 

	public float getCostefinal() {
		return costefinal;
	}

	public void setCostefinal(float costefinal) {
		this.costefinal = costefinal;
	}
	
	
	
}
