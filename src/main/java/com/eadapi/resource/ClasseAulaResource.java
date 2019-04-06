package com.eadapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eadapi.event.RecursoCriadoEvent;
import com.eadapi.model.ClasseAula;
import com.eadapi.repository.ClasseAulaRepository;
import com.eadapi.service.ClasseAulaService;

@RestController
@RequestMapping("classe_aula")
public class ClasseAulaResource {
	
	@Autowired
	private ClasseAulaRepository classeAulaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClasseAulaService classeAulaService;

	@GetMapping
	public List<ClasseAula> listar(){
		return classeAulaRepository.findAll();
	}
	
	@GetMapping("/{idClasseAula}")
	public ResponseEntity<ClasseAula> buscarPorId(@PathVariable Long idClasseAula){ 
		
		ClasseAula classeAula = classeAulaRepository.findOne(idClasseAula);
		return classeAula != null ? ResponseEntity.ok(classeAula) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ClasseAula> salvar(@RequestBody @Valid ClasseAula classeAula, HttpServletResponse response){
		ClasseAula classeAulaSalva = classeAulaRepository.save(classeAula);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, classeAulaSalva.getIdClasseAula()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(classeAulaSalva);
	}
	
	@DeleteMapping
	@ResponseStatus
	public void remover(@PathVariable Long idClasseAula) {
		classeAulaRepository.delete(idClasseAula);
	}
	
	@PutMapping
	public ResponseEntity<ClasseAula> atualizar(@PathVariable Long idClasseAula, @RequestBody @Valid ClasseAula classeAula){
		ClasseAula classeAulaSalva = classeAulaService.atualizar(idClasseAula, classeAula);
		
		return ResponseEntity.ok(classeAulaSalva);
	}
}
