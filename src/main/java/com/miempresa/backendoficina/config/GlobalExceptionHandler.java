package com.miempresa.backendoficina.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Captura las excepciones globales para toda la API
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Si lanzas RuntimeException con "Credenciales" en el mensaje, retorna 401
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        if (ex.getMessage() != null && ex.getMessage().toLowerCase().contains("credenciales")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
        // Otros errores: 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
    }
}