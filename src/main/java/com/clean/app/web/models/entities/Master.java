package com.clean.app.web.models.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity()
@Table(name = "MASTER")
public class Master implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDMASTER")
	private Integer idmaster;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FECHA")
	private Calendar fecha;
	
	@Column(name="TIEMPO")
	private Time tiempo;
	
	@Column(name="OBSERVACION")
	@Size(max=50)
	private String observacion;
	
	@JoinColumn(name="IDCLIENTE",referencedColumnName="IDCLIENTE")
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy="master", fetch=FetchType.LAZY)
	private List<Pedido> pedido;
	
	public Master() {
		super();
	}
	
	public Master(Integer id) {
		super();
		this.idmaster=id;
	}

	public Integer getIdmaster() {
		return idmaster;
	}

	public void setIdmaster(Integer idmaster) {
		this.idmaster = idmaster;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
