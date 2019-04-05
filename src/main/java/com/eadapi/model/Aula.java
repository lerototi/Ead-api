package com.eadapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aula")
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_aula")
	private Long idAula;
	@NotNull(message="Nome não pode ser nulo")
	private String nome;
	private String url;
	private String texto;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "fk_aula_pai", insertable = true, updatable = true, nullable = true)
	private Aula aulaPai;
	
	
	public Long getIdAula() {
		return idAula;
	}
	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Aula getAulaPai() {
		return aulaPai;
	}
	public void setAulaPai(Aula aulaPai) {
		this.aulaPai = aulaPai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulaPai == null) ? 0 : aulaPai.hashCode());
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
		Aula other = (Aula) obj;
		if (aulaPai == null) {
			if (other.aulaPai != null)
				return false;
		} else if (!aulaPai.equals(other.aulaPai))
			return false;
		return true;
	}
	


}
