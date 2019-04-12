package com.eadapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="curso")
@Entity
public class Curso {

	@Id
	@GeneratedValue
	@Column(name="id_curso")
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
	@Enumerated(EnumType.STRING)
	private Acesso acesso;
	
	@Column
	private Date criacao;
	
	@Column
	private Date termino;
	
	@Column 
	private Date lancamento;
	
	@Column
	private Boolean ativo;
	
	@OneToMany(mappedBy="curso")
	private List<CursoUsuario> usuarioCursos;


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
