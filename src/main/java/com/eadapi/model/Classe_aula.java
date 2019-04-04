package com.eadapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="classe_aula")
public class Classe_aula {

	@Id
	@GeneratedValue
	private Long idClasse_aula;
	
	@ManyToOne
	@JoinColumn(name="fk_classe", nullable=false)
	private Classe classe;
	
	@ManyToOne
	@JoinColumn(name="fk_aula", nullable=false)
	private Aula aula;
	
	@OneToOne
	@JoinColumn(name="fk_usuario", referencedColumnName="idUsuario")
	private Usuario Usuario;
	
	@Column
	private Date dataRegistro;

	public Long getIdClasse_aula() {
		return idClasse_aula;
	}

	public void setIdClasse_aula(Long idClasse_aula) {
		this.idClasse_aula = idClasse_aula;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
	
}
