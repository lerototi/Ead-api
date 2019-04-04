package com.eadapi.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Perfil {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String imagem;


	
}
