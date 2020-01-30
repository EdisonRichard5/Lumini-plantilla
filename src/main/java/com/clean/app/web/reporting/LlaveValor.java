package com.clean.app.web.reporting;
import java.io.Serializable;
import java.math.BigInteger;

public class LlaveValor implements Serializable{

	private static final long serialVersionUID = 1L;

	private String llave;

	private BigInteger valor;
	
	private Integer valor2;

	public Integer getValor2() {
		return valor2;
	}



	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}



	public LlaveValor() {		
	}



	public LlaveValor(String llave, BigInteger valor,Integer valor2) {
		super();
		this.llave = llave;
		this.valor = valor;
		this.valor2 = valor2;
	}



	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public BigInteger getValor() {
		return valor;
	}

	public void setValor(BigInteger valor) {
		this.valor = valor;
	}







}