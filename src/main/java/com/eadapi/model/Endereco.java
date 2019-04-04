package com.eadapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String logradouro;
	private Long numero;
	private String complemento;
	private String cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
