package com.eadapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadapi.event.RecursoCriadoEvent;
import com.eadapi.model.CursoUsuario;
import com.eadapi.repository.CursoUsuarioRepository;
import com.eadapi.service.CursoUsuarioService;

@RestController
@RequestMapping("/cursoUsuario")
public class CursoUsuarioResource {

	
	@Autowired
	private CursoUsuarioRepository cursoUsuarioRepository;
	
	@Autowired ApplicationEventPublisher publisher;
	
	@Autowired
	public CursoUsuarioService cursoUsuarioService;
	
	@GetMapping
	public List<CursoUsuario> listar(){
		
		return cursoUsuarioRepository.findAll();
	}
	
	@GetMapping("/{idCursoUsuario}")
	private ResponseEntity<CursoUsuario> buscarPorId(@PathVariable Long idCursoUsuario){
		
		CursoUsuario cursoUsuarioSalvo = cursoUsuarioRepository.getOne(idCursoUsuario);
		
		return cursoUsuarioSalvo != null ? ResponseEntity.ok(cursoUsuarioSalvo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	private ResponseEntity<CursoUsuario> salvar(@RequestBody @Valid CursoUsuario cursoUsuario, HttpServletResponse response){
		
		CursoUsuario cursoUsuarioSalvo = cursoUsuarioRepository.save(cursoUsuario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cursoUsuarioSalvo.getIdCursoUsuario()));
		
		return ResponseEntity.ok(cursoUsuarioSalvo);
	}
	
	@PutMapping("/{idCursoUsuario}")
	public ResponseEntity<CursoUsuario> alterar(@PathVariable Long idCursoUsuario, @RequestBody @Valid CursoUsuario cursoUsuario){
		
		CursoUsuario cursoUsuarioSalvo = cursoUsuarioService.alterar(idCursoUsuario, cursoUsuario);
		
		return ResponseEntity.ok(cursoUsuarioSalvo);
	}
	
}
