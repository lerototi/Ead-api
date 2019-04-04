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
@Table(name="usuario_classe")
public class UsuarioClasse {

	
	@GeneratedValue
	@Id
	private Long idUsuarioClasse;
	
	@Column
	private Date ingresso;

	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_classe")
	private Classe classe;

	public Long getIdUsuarioClasse() {
		return idUsuarioClasse;
	}

	public void setIdUsuarioClasse(Long idUsuarioClasse) {
		this.idUsuarioClasse = idUsuarioClasse;
	}

	public Date getIngresso() {
		return ingresso;
	}

	public void setIngresso(Date ingresso) {
		this.ingresso = ingresso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
