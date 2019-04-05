package com.eadapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso_classe")
public class CursoClasse {

	@Id
	@GeneratedValue
	@Column(name="id_curso_classe")
	private Long idCursoClasse;
	
	
	@ManyToOne
	@JoinColumn(name="fk_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="fk_classe")
	private Classe classe;
	
	@OneToOne
	@JoinColumn(name="fk_usuario_criador")
	private Usuario usuarioCriador;
	
	@Column(name="data_registro")
	private Date dataRegistro;

	public Long getIdCursoClasse() {
		return idCursoClasse;
	}

	public void setIdCursoClasse(Long idCursoClasse) {
		this.idCursoClasse = idCursoClasse;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
	
	
}
