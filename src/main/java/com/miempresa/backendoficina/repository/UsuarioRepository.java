package com.miempresa.backendoficina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.backendoficina.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}