package com.miempresa.backendoficina;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpleadoRegistroTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegistroEmpleadoExitoso() throws Exception {
        String body = """
            {
              "username": "empleadotest1",
              "password": "test1234",
              "nombres": "Juan",
              "apellidos": "Pérez",
              "telefono": "123456789",
              "direccion": "Calle Falsa 123",
              "formacion": "Ingeniero"
            }
        """;

        mockMvc.perform(post("/empleados/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.usuario.username").value("empleadotest1"));
    }
}