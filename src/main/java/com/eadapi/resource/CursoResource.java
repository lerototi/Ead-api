package com.eadapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.eadapi.model.Curso;
import com.eadapi.repository.CursoRepository;
import com.eadapi.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoResource {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired 
	private CursoService cursoService;
	
	
	@GetMapping
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{idCurso}")
	public ResponseEntity<Curso> buscarPorId(@PathVariable Long idCurso){
		
		Curso cursoSalvo = cursoRepository.findOne(idCurso);
		
		return cursoSalvo != null ? ResponseEntity.ok(cursoSalvo) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PostMapping
	public ResponseEntity<Curso> salvar(@RequestBody Curso curso, HttpServletResponse response){
	
		Curso cursoSalvo = cursoRepository.save(curso);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cursoSalvo.getIdCurso()));
				
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	@DeleteMapping("/{idCurso}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idCurso) {
		cursoRepository.delete(idCurso);
	}
	
	@PutMapping("/{idCruso}")
	public ResponseEntity<Curso> alterar(@PathVariable Long idCurso, @RequestBody Curso curso){
		
		Curso cursoSalvo = cursoService.atualizar(idCurso, curso);
		
		return ResponseEntity.ok(cursoSalvo);
	}
	
	
	
}
