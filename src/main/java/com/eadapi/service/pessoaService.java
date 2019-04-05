package com.eadapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eadapi.model.Pessoa;
import com.eadapi.repository.PessoaRepository;

@Service
public class pessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long idPessoa, Pessoa pessoa) {
		
		Pessoa pessoaSalva = pessoaRepository.findOne(idPessoa);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "idPessoa");
		
		return pessoaRepository.save(pessoaSalva);
	}
	
	
	
}
