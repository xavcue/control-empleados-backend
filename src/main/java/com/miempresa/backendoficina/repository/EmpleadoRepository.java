package com.miempresa.backendoficina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.backendoficina.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByUsuarioId(Long usuarioId);
}