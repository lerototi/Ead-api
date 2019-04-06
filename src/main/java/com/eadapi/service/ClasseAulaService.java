package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.ClasseAula;
import com.eadapi.repository.ClasseAulaRepository;

@Service
public class ClasseAulaService {

	@Autowired
	private ClasseAulaRepository classeAulaRepository;

	public ClasseAula atualizar(Long idClasseAula, ClasseAula classeAula) {

		ClasseAula classeAulaSalva = classeAulaRepository.getOne(idClasseAula);
		if (classeAulaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(idClasseAula, classeAulaSalva, "idClasseAula");
		
		return classeAulaRepository.save(classeAulaSalva);
	}
	
	
	
}
