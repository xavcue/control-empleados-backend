package com.miempresa.backendoficina.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.miempresa.backendoficina.dto.EmpleadoDTO;
import com.miempresa.backendoficina.model.Empleado;
import com.miempresa.backendoficina.model.Usuario;
import com.miempresa.backendoficina.service.EmpleadoService;
import com.miempresa.backendoficina.service.UsuarioService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Listar todos los empleados (solo para admin)
    @GetMapping
    public List<Empleado> getAll() {
        return empleadoService.findAll();
    }

    // Obtener empleado por ID (opcional, útil para el admin)
    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Long id) {
        return empleadoService.findById(id).orElseThrow();
    }

    // Obtener perfil del propio empleado autenticado
    @GetMapping("/me")
    public Empleado getMyData(Principal principal) {
        Usuario usuario = usuarioService.findByUsername(principal.getName()).orElseThrow();
        return empleadoService.findByUsuarioId(usuario.getId()).orElseThrow();
    }

    // Registrar un nuevo empleado (solo admin)
    @PostMapping("/register")
    public Empleado registerEmpleado(@RequestBody Map<String, String> body) {
        Usuario usuario = new Usuario();
        usuario.setUsername(body.get("username"));
        usuario.setPassword(passwordEncoder.encode(body.get("password")));
        usuario.setRol("EMPLEADO");
        usuarioService.save(usuario);

        Empleado empleado = new Empleado();
        empleado.setNombres(body.get("nombres"));
        empleado.setApellidos(body.get("apellidos"));
        empleado.setTelefono(body.get("telefono"));
        empleado.setDireccion(body.get("direccion"));
        empleado.setFormacion(body.get("formacion"));
        empleado.setUsuario(usuario);
        return empleadoService.save(empleado);
    }

    // Actualizar datos de un empleado por el admin
    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoService.findById(id).orElseThrow();
        empleado.setNombres(empleadoDTO.getNombres());
        empleado.setApellidos(empleadoDTO.getApellidos());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setFormacion(empleadoDTO.getFormacion());
        return empleadoService.save(empleado);
    }

    // Actualizar datos del propio empleado autenticado
    @PutMapping("/me")
    public Empleado updateMyData(Principal principal, @RequestBody EmpleadoDTO empleadoDTO) {
        Usuario usuario = usuarioService.findByUsername(principal.getName()).orElseThrow();
        Empleado empleado = empleadoService.findByUsuarioId(usuario.getId()).orElseThrow();

        empleado.setNombres(empleadoDTO.getNombres());
        empleado.setApellidos(empleadoDTO.getApellidos());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setFormacion(empleadoDTO.getFormacion());

        return empleadoService.save(empleado);
    }

    // Eliminar empleado (solo admin)
    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteById(id);
    }
}