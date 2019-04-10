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
import com.eadapi.model.Perfil;
import com.eadapi.repository.PerfilRepository;
import com.eadapi.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired 
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PerfilService perfilService;
	
	
	@GetMapping
	public List<Perfil> listar(){
	
		return perfilRepository.findAll();
	}
	
	@GetMapping("/{idPerfil}")
	public ResponseEntity<Perfil> buscarPorId(@PathVariable Long idPerfil){
		
		Perfil perfilSalvo = perfilRepository.getOne(idPerfil);
		
		return perfilSalvo!= null ? ResponseEntity.ok(perfilSalvo) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PostMapping
	public ResponseEntity<Perfil> salvar (@RequestBody @Valid Perfil perfil, HttpServletResponse response){
		
		Perfil perfilSalvo = perfilRepository.save(perfil);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, perfilSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilSalvo);
		
	}
	
	@DeleteMapping("/{idPerfil}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idPerfil) {
		perfilRepository.delete(idPerfil);
	}
	
	@PutMapping
	public ResponseEntity<Perfil> atualizar(@PathVariable Long idPerfil, @RequestBody @Valid Perfil perfil){
		
		Perfil perfilSalvo = perfilService.atualizar(idPerfil, perfil);
		
		return ResponseEntity.ok(perfilSalvo);
	}
}
