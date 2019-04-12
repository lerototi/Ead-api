package com.eadapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name="curso_usuario")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CursoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_curso_usuario")
	private Long idCursoUsuario;
	
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
	@JsonManagedReference
	@JoinColumn(name="fk_usuario", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuario;


	public Long getIdCursoUsuario() {
		return idCursoUsuario;
	}

	public void setIdCursoUsuario(Long idCursoUsuario) {
		this.idCursoUsuario = idCursoUsuario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCursoUsuario == null) ? 0 : idCursoUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoUsuario other = (CursoUsuario) obj;
		if (idCursoUsuario == null) {
			if (other.idCursoUsuario != null)
				return false;
		} else if (!idCursoUsuario.equals(other.idCursoUsuario))
			return false;
		return true;
	}
	
	
	
}
