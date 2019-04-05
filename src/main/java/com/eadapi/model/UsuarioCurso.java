package com.eadapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="usuario_curso")
@Entity
public class UsuarioCurso {

	@Id
	@GeneratedValue
	@Column(name="id_usuario_curso")
	private Long idUsuarioCurso;
	
	@Column
	private Boolean pago;
	
	@Column(name="valor_pago")
	private Double valorPago;
	
	@Column(name="data_pagamento")
	private Date dataPagamento;
	
	@Column
	private String promo;
	
	@ManyToOne
	@JoinColumn(name="fk_curso", nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario", nullable=false)
	private Usuario usuario;



	public Long getIdUsuarioCurso() {
		return idUsuarioCurso;
	}

	public void setIdUsuarioCurso(Long idUsuarioCurso) {
		this.idUsuarioCurso = idUsuarioCurso;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
