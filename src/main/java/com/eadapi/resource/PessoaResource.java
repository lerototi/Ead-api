package com.eadapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadapi.event.RecursoCriadoEvent;
import com.eadapi.model.Pessoa;
import com.eadapi.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Pessoa> listar() {
		
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	private ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getIdPessoa()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long idPessoa){
	
		Pessoa pessoa = pessoaRepository.findOne(idPessoa);
		
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}
	
	

	
}