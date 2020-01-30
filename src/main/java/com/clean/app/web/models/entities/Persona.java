package com.clean.app.web.models.entities;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;//JPA que es nuestro ORM, mapea una tabla a la clase
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Persona{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPERSONA")
	private Integer idpersona;
	
	@Column(name="NOMBRES")
	//@Pattern(regexp ="[A-Za-z]+", message="Un nombre puede tener unicamente letras")
	@Size(max=45, message="Los nombres no debe tener 45 caracteres")
	private String nombres;
	
	@Column(name="APELLIDOS")
	//@Pattern(regexp ="[A-Za-z]+", message="Los apellidos puede tener unicamente letras")
	@Size(max=45, message="Los nombres no debe tener 45 caracteres")
	private String apellidos;
	
	@Column(name="CEDULA")
	@Size(max=10)
	private String cedula;

	@Column(name="TELEFONO")
	@Size(max=10)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="NACIMIENTO")
	private Calendar nacimiento;
	
	
	@Column(name="LUGARNACIMIENTO")
	@Size(max=255)
	private String lugarNacimiento;
	
	@Column(name="SEXO")
	@Size(max=1)
	private String sexo;
	
	@Column(name="CORREO")
	@Size(max=50, min=12, message="Correo no valido")
	private String correo;

	public Persona() {
		super();
	}

	public Persona(Integer id) {
		super();
		this.idpersona = id;
	}
	
	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}



	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}	
	
	
	
	public Calendar getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	
	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	@Override
	public String toString() {
		return apellidos + " "+nombres;
	}
}