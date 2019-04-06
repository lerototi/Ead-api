package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.Classe;
import com.eadapi.repository.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;

	public Classe atualizar(Long idClasse, Classe classe) {
		Classe classeSalva = classeRepository.findOne(idClasse);
		if (classeSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(classe, classeSalva, "idClasse");
		
		return classeRepository.save(classeSalva);
	}
	
	

}
