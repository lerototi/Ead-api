package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.Perfil;
import com.eadapi.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public Perfil atualizar(Long idPerfil, Perfil perfil) {

		Perfil perfilSalvo = perfilRepository.getOne(idPerfil);
		
		if(perfil == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(perfil, perfilSalvo, "idPerfil");
		
		return perfilRepository.save(perfilSalvo);
	}
	
	
	
}
