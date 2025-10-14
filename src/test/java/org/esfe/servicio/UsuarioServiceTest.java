package org.esfe.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioServiceTest {
     private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
    }

    // Clase interna para mantener todo en un solo archivo (no necesitas crear otra)
    class UsuarioService {
        public String registrarUsuario(String nombre, String correo, String contrasena) {
            if (nombre == null || correo == null || contrasena == null) {
                throw new IllegalArgumentException("Los campos no pueden ser nulos");
            }
            return "Usuario registrado: " + nombre + ", " + correo;
        }
    }

    @Test
    void registrarUsuario_DebeRegistrarCorrectamente() {
        String nombre = "Cristian";
        String correo = "cristian@correo.com";
        String contrasena = "12345";

        String resultado = usuarioService.registrarUsuario(nombre, correo, contrasena);

        System.out.println("TEST 1: " + resultado);

        assertTrue(resultado.contains(nombre), "El nombre debe estar en el mensaje");
        assertTrue(resultado.contains(correo), "El correo debe estar en el mensaje");
    }
}
