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
import javax.validation.constraints.Size;

@Entity()
@Table(name = "HERRAMIENTA")
public class Herramienta implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDHERRAMIENTA")
	private Integer idherramienta;
	
	@Column(name="NOMBRE")
	@Size(max=20)
	private String nombre;
	
	@Column(name="PRECIO")
	private float precio ;
	
	@Column(name="CANTIDAD")
	private Integer cantidad ;
	
	@Column(name="TIPO")
	private String tipo ;
	
	@OneToMany(mappedBy="herramienta", fetch=FetchType.LAZY)
	private List<Pedido> pedido;
	
	public Herramienta() {
		super();
	}
	
	public Herramienta(Integer id) {
		super();
		this.idherramienta=id;
	}

	public Integer getIdherramienta() {
		return idherramienta;
	}

	public void setIdherramienta(Integer idherramienta) {
		this.idherramienta = idherramienta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
