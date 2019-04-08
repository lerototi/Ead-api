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
import com.eadapi.model.CursoClasse;
import com.eadapi.repository.CursoClasseRepository;
import com.eadapi.service.CursoClasseService;

@RestController
@RequestMapping("/cursoClasse")
public class CursoClasseResource {

	@Autowired
	private CursoClasseRepository cursoClasseRepository;
	
	@Autowired
	public ApplicationEventPublisher publisher;
	
	@Autowired
	public CursoClasseService cursoClasseService;
	
	
	@GetMapping
	public List<CursoClasse> listar(){
		return cursoClasseRepository.findAll();
	}
	
	@GetMapping("/{idCursoClasse}")
	public ResponseEntity<CursoClasse> buscarPorId(@PathVariable Long IdCursoClasse){
		CursoClasse curssoClasseSalva = cursoClasseRepository.findOne(IdCursoClasse);
		
		return curssoClasseSalva != null ? ResponseEntity.ok(curssoClasseSalva) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
	
	@PostMapping
	public ResponseEntity<CursoClasse> salvar(@RequestBody @Valid CursoClasse cursoClasse, HttpServletResponse response){
		
		CursoClasse cursoClasseSalva = cursoClasseRepository.save(cursoClasse);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cursoClasseSalva.getIdCursoClasse()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoClasseSalva);
	}
	
	@DeleteMapping("/{idCursoClasse}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idCursoClasse) {
		
		cursoClasseRepository.delete(idCursoClasse);
		
	}
	
	@PutMapping("/{idCursoClasse}")
	public ResponseEntity<CursoClasse> atualizar(@PathVariable @Valid Long idCursoClasse, @RequestBody CursoClasse cursoClasse){
		
		CursoClasse cursoClasseSalvo = cursoClasseService.atualizar(idCursoClasse, cursoClasse);
		
		return ResponseEntity.ok(cursoClasseSalvo);
	}
	
	
}
