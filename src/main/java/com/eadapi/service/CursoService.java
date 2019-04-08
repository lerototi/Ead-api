package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eadapi.model.Curso;
import com.eadapi.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public Curso atualizar(Long idCurso, Curso curso) {

		Curso cursoSalvo = cursoRepository.findOne(idCurso);
		
		BeanUtils.copyProperties(curso, cursoSalvo, "idCurso");
		
		return cursoRepository.save(cursoSalvo);
	}
	

	
}
