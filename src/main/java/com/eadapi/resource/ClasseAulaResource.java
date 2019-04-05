package com.eadapi.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadapi.model.ClasseAula;

@RestController
@RequestMapping("classe_aula")
public class ClasseAulaResource {

	@GetMapping
	public List<ClasseAula> listar(){
		return null;
	}
}
