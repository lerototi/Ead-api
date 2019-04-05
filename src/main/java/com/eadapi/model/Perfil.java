package com.eadapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Perfil {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String imagem;


	
}
