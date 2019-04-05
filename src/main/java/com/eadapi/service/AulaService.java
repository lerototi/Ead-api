package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.Aula;
import com.eadapi.repository.AulaRepository;

@Service
public class AulaService {

	@Autowired
	private AulaRepository aulaRepository;
	
	public Aula autalizar(Long idAula, Aula aula) {
	Aula aulaSalva = aulaRepository.findOne(idAula);
		if(aulaSalva==null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(aula, aulaSalva, "idAula");
		return aulaRepository.save(aulaSalva);
	}
}
