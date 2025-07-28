package com.miempresa.backendoficina;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEmpleadosSinAutenticacion() throws Exception {
        // No autenticado, debería devolver 403 Forbidden (o 401 según config)
        mockMvc.perform(get("/empleados"))
                .andExpect(status().isForbidden()); // Cambia a isUnauthorized si tu app responde 401
    }
}