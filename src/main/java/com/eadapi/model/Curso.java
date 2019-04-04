package com.eadapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Curso {

	@Id
	@GeneratedValue
	private Long idCurso;
	
	@Column
	private String nome;
	
	@Column
	private Double valor;
	
	@Column
	private String descricao;
	
	@Column
	private Integer maxAlunos;
	
	@Column
	@Enumerated
	private Acesso acesso;
	
	@Column
	private Date criacao;
	
	@Column
	private Date termino;
	
	@Column 
	private Date lancamento;
	
	@Column
	private Boolean ativo;


	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
