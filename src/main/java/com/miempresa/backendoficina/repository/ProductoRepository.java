package com.miempresa.backendoficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.backendoficina.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}