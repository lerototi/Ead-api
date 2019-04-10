package com.eadapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.aspectj.weaver.tools.ISupportsMessageContext;
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
import com.eadapi.model.Usuario;
import com.eadapi.repository.UsuarioRepository;
import com.eadapi.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioResource {

	
	@Autowired  
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long idUsuario){
		
		Usuario usuarioSalvo = usuarioRepository.getOne(idUsuario);
		
		return usuarioSalvo != null ? ResponseEntity.ok(usuarioSalvo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario, HttpServletResponse response){
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getIdUsuario()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@DeleteMapping("/{idUauario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long idUsuario) {
		usuarioRepository.delete(idUsuario);
	}
	
	@PutMapping("/{idUsuario}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioService.atualizar(idUsuario, usuario);
		
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping("/{idUsuario}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long idUsuario, @RequestBody Boolean ativo) {
		usuarioService.atualizarPropAtivo(idUsuario, ativo);
	}
	
}
