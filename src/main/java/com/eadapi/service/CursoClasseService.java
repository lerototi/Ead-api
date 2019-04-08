package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.CursoClasse;
import com.eadapi.repository.CursoClasseRepository;

@Service
public class CursoClasseService {

	
	@Autowired
	public CursoClasseRepository cursoClasseRepository;

	public CursoClasse atualizar(Long idCursoClasse, CursoClasse cursoClasse) {

		CursoClasse cursoClasseSalvo = cursoClasseRepository.findOne(idCursoClasse);
		
		if (cursoClasseSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(cursoClasse, cursoClasseSalvo, "idCursoClasse");
		
		return cursoClasseRepository.save(cursoClasseSalvo);
	}
	
}
