package com.eadapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long idUsuario;

	@Column
	@NotNull
	private String login;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String senha;
	
	@Column
	@NotNull
	private Date cadastro;
	
	@Column
	@NotNull
	private boolean ativo;
	
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioClasse> usuarioClasses; 


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<UsuarioClasse> getUsuarioClasses() {
		return usuarioClasses;
	}

	public void setUsuarioClasses(List<UsuarioClasse> usuarioClasses) {
		this.usuarioClasses = usuarioClasses;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

	
}
