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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDCLIENTE")
	private Integer idcliente;
	
	@Column(name="NOMBRE")
	@Size(max=20)
	private String nombre;
	
	@Column(name="DIRECCION")
	@Size(max=50)
	private String direccion;
	
	@Column(name="TELEFONO")
	@Size(max=10)
	private String telefono;
	
	@Column(name="OBSERVACION")
	@Size(max=50)
	private String observacion;
		
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Master> master;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Integer id) {
		super();
		this.idcliente=id;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<Master> getMaster() {
		return master;
	}

	public void setMaster(List<Master> master) {
		this.master = master;
	}
}
