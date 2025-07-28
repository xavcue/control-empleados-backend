package com.miempresa.backendoficina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.miempresa.backendoficina.model.Usuario;
import com.miempresa.backendoficina.repository.UsuarioRepository;

@Component
public class StartupAdminConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin12345"));
            admin.setRol("ADMIN"); // mayúsculas
            usuarioRepository.save(admin);
            System.out.println("Usuario admin creado por defecto");
        }
    }
}