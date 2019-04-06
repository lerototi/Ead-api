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
import com.eadapi.model.Classe;
import com.eadapi.repository.ClasseRepository;
import com.eadapi.service.ClasseService;

@RestController
@RequestMapping("/classe")
public class ClasseResource {

	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClasseService classeService;
	
	@GetMapping
	public List<Classe> listar(){
		return classeRepository.findAll();
	}
	
	@GetMapping("/{idClasse}")
	public ResponseEntity<Classe> buscaPorId(@PathVariable Long idClasse){
		
		Classe classeSalva = classeRepository.findOne(idClasse);
		
		return classeSalva != null ? ResponseEntity.ok(classeSalva) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@PostMapping
	public ResponseEntity<Classe> salvar (@RequestBody @Valid Classe classe, HttpServletResponse response){
		
		Classe classeSalva = classeRepository.save(classe);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, classeSalva.getIdClasse()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(classeSalva);
	}
	
	@DeleteMapping("/{idClasse}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idClasse) {
		
		classeRepository.delete(idClasse);
	}
	
	@PutMapping("/{idClasse}")
	public ResponseEntity<Classe> atualizar(@PathVariable Long idClasse, @RequestBody @Valid Classe classe ){
		
		Classe classeSalva = classeService.atualizar(idClasse, classe);
		
		return ResponseEntity.ok(classeSalva);
	}
}
