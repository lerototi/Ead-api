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
public class ClasseAula {

	@Id
	@GeneratedValue
	private Long idClasseAula;
	
	@ManyToOne
	@JoinColumn(name="fk_classe", nullable=false)
	private Classe classe;
	
	@ManyToOne
	@JoinColumn(name="fk_aula", nullable=false)
	private Aula aula;
	
	@OneToOne
	@JoinColumn(name="fk_usuario", referencedColumnName="idUsuario")
	private Usuario Usuario;
	
	@Column(name="data_aula_iniciada")
	private Date dataInicio;
	
	@Column(name="data_aula_completa")
	private Date dataFim;
	
	@Column(name="aula_iniciada")
	private Boolean aulaIniciada;
	
	@Column(name="aula_completa")
	private Boolean aulaCompleta;
	
	public Long getIdClasseAula() {
		return idClasseAula;
	}

	public void setIdClasseAula(Long idClasseAula) {
		this.idClasseAula = idClasseAula;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean getAulaIniciada() {
		return aulaIniciada;
	}

	public void setAulaIniciada(Boolean aulaIniciada) {
		this.aulaIniciada = aulaIniciada;
	}

	public Boolean getAulaCompleta() {
		return aulaCompleta;
	}

	public void setAulaCompleta(Boolean aulaCompleta) {
		this.aulaCompleta = aulaCompleta;
	}

}
