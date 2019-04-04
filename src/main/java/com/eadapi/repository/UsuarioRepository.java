package com.eadapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eadapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
