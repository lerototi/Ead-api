package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.CursoUsuario;
import com.eadapi.repository.CursoUsuarioRepository;

@Service
public class CursoUsuarioService {

	@Autowired
	private CursoUsuarioRepository cursoUsuarioRepository;

	public CursoUsuario alterar(Long idCursoUsuario, CursoUsuario cursoUsuario) {

		CursoUsuario cursoUsuarioSalvo = cursoUsuarioRepository.findOne(idCursoUsuario);
		
		if (cursoUsuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(cursoUsuario, cursoUsuarioSalvo, "idCursoUsuario");
		
		return cursoUsuarioRepository.save(cursoUsuarioSalvo);
	}
	
	
	
}
