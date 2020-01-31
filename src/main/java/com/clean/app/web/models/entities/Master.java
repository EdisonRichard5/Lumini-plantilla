package com.clean.app.web.models.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
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
	

	
	@Transient
	private int clienteid;
		

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "IDMASTER")
	private List<Pedido> detalles;
	
	public Master() {
		super();
	}
	
	public Master(Integer id) {
		super();
		this.idmaster=id;
	}
 
	//Bitácora
	@Column(name="CREADOPOR")
	@Size(max=35)
	private String creadoPor;
	
	@Column(name="CREADOEN")
	private Calendar creadoEn;
	@PrePersist
    public void prePersist() {
        creadoEn = Calendar.getInstance();
        SecurityContext context = SecurityContextHolder.getContext();
        creadoPor = context.getAuthentication().getName();
    }
    
	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Calendar getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Calendar creadoEn) {
		this.creadoEn = creadoEn;
	}

	public List<Pedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Pedido> detalles) {
		this.detalles = detalles;
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
		return detalles;
	}

	public void setPedido(List<Pedido> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	 
	
}
