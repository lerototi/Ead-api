package com.eadapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario_assiste_aulas")
public class UsuarioAssisteAulas {

	
	@Id
	@GeneratedValue
	private Long idUsuarioAssisteAulas;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="fk_aula")
	private Aula aula;
	
	@Column(name="data_aula_completa")
	private Date dataAulaCompleta;
	
	@Column(name="aula_completa")
	private Boolean aulaCompleta;

	public Long getIdUsuarioAssisteAulas() {
		return idUsuarioAssisteAulas;
	}

	public void setIdUsuarioAssisteAulas(Long idUsuarioAssisteAulas) {
		this.idUsuarioAssisteAulas = idUsuarioAssisteAulas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Date getDataAulaCompleta() {
		return dataAulaCompleta;
	}

	public void setDataAulaCompleta(Date dataAulaCompleta) {
		this.dataAulaCompleta = dataAulaCompleta;
	}

	public Boolean getAulaCompleta() {
		return aulaCompleta;
	}

	public void setAulaCompleta(Boolean aulaCompleta) {
		this.aulaCompleta = aulaCompleta;
	}
	
	
}
