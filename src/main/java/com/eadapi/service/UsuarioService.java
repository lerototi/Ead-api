package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.Usuario;
import com.eadapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario atualizar(Long idUsuario, Usuario usuario) {

		Usuario usuarioSalvo = usuarioRepository.findOne(idUsuario);
		if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(usuario, usuarioSalvo, "idUsuario");
		
		return usuarioRepository.save(usuarioSalvo);
	}
	
	
}
