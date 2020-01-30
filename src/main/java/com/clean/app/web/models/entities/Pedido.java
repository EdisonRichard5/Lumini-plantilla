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


@Entity()
@Table(name = "PEDIDO")
public class Pedido implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPEDIDO")
	private Integer idpedido;
	
	@JoinColumn(name="IDPRODUCTO",referencedColumnName="IDPRODUCTO")
	@ManyToOne
	private Producto producto;
	
	@JoinColumn(name="IDHERRAMIENTA",referencedColumnName="IDHERRAMIENTA")
	@ManyToOne
	private Herramienta herramienta;
	
	@JoinColumn(name="IDSERVICIO",referencedColumnName="IDSERVICIO")
	@ManyToOne
	private Servicio servicio;
	
	@JoinColumn(name="IDEMPLEADO",referencedColumnName="IDEMPLEADO")
	@ManyToOne
	private Empleado empleado;
	
	
	
	@JoinColumn(name="IDMASTER",referencedColumnName="IDMASTER")
	@ManyToOne
	private Master master;
	
	@Column(name="SOLICITUD")
	@Size(max=500)
	private String solicitud;
	
	@Column(name="ESTADO")
	@Size(max=1)
	private Integer estado ;
	
	@Column(name="COSTEFINAL")
	@Size(max=50)
	private float costefinal;

	
	public Pedido() {
		super();
	}
	
	public Pedido(Integer id) {
		super();
		this.idpedido=id;
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

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public float getCostefinal() {
		return costefinal;
	}

	public void setCostefinal(float costefinal) {
		this.costefinal = costefinal;
	}
	
}
