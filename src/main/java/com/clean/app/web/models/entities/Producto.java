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


@Entity()
@Table(name = "PRODUCTO")
public class Producto implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPRODUCTO")
	private Integer idproducto;
	
	@Column(name="NOMBRE")
	@Size(max=20)
	private String nombre;
	
	@Column(name="TIPO")
	@Size(max=20)
	private String tipo;
	
	@Column(name="PRECIO")
	private float precio ;
	
	
	@OneToMany(mappedBy="producto", fetch=FetchType.LAZY)
	private List<Pedido> pedido;
	
	public Producto() {
		super();
	}
	
	public Producto(Integer id) {
		super();
		this.idproducto=id;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
