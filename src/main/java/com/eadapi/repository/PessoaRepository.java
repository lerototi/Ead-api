package com.eadapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eadapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
