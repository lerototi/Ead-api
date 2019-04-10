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
import com.eadapi.model.Plano;
import com.eadapi.repository.PlanoRepository;
import com.eadapi.service.PlanoService;

@RestController
@RequestMapping("/plano")
public class PlanoResource {

	@Autowired
	private PlanoRepository planoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PlanoService planoService;
	
	@GetMapping
	public List<Plano> listar(){
		return planoRepository.findAll();
	}
	
	@GetMapping("/{idPlano}")
	public ResponseEntity<Plano> buscarPorId(@PathVariable Long idPlano){
		Plano planoSalvo = planoRepository.getOne(idPlano);
		
		
		
		return planoSalvo != null ? ResponseEntity.ok(planoSalvo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Plano> salvar(@RequestBody @Valid Plano plano, HttpServletResponse response){
		
		Plano planoSalvo = planoRepository.save(plano);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, planoSalvo.getIdPlano().longValue()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(planoSalvo);
	}
	
	@DeleteMapping("/{idPlano}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idPlano){
		planoRepository.delete(idPlano);
	}
	
	
	@PutMapping("/{idPlano}")
	public ResponseEntity<Plano> atualizar(@RequestBody Plano plano, @PathVariable Long idPlano){
		
		Plano planoSalvo = planoService.atualizar(plano, idPlano);
		
		return ResponseEntity.ok(planoSalvo);
	}
	
}
