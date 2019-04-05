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
import com.eadapi.model.Aula;
import com.eadapi.repository.AulaRepository;
import com.eadapi.service.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaResource {
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AulaService aulaService;

	@GetMapping
	public List<Aula> listar(){
		return aulaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Aula> criar(@Valid @RequestBody Aula aula, HttpServletResponse response) {
		Aula aulaSalva = aulaRepository.save(aula);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, aulaSalva.getIdAula()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaSalva);
	}
	
	@GetMapping("/{idAula}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long idAula){
		Aula aula = aulaRepository.findOne(idAula);
		return aula != null ? ResponseEntity.ok(aula) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idAula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long idAula) {
		aulaRepository.delete(idAula);
	}
	
	
	@PutMapping("{idAula}")
	public ResponseEntity<Aula> atualizar(@PathVariable Long idAula, @Valid @RequestBody Aula aula){
		Aula aulaSalva = aulaService.autalizar(idAula, aula);
		return ResponseEntity.ok(aulaSalva);
	}
	
}
