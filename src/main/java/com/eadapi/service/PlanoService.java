package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eadapi.model.Plano;
import com.eadapi.repository.PlanoRepository;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository planoRepository;

	public Plano atualizar(Plano plano, Long idPlano) {
		
		Plano planoSalvo = planoRepository.findOne(idPlano);
		
		BeanUtils.copyProperties(plano, planoSalvo, "idPlano");
		
		
		return planoRepository.save(planoSalvo);
	}
	
	
}
