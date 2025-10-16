package org.esfe.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
    }

    // Clase interna para mantener todo en un solo archivo (no necesitas crear otra)
    class UsuarioService {
        private String usuarioRegistrado;

        // Simula el registro de un usuario
        public void registrarUsuario(String nombre, String correo, String contrasena) {
            if (nombre == null || correo == null || contrasena == null) {
                throw new IllegalArgumentException("Los campos no pueden ser nulos");
            }
            this.usuarioRegistrado = nombre + ", " + correo;
        }

        // Simula la obtención del usuario registrado
        public String obtenerUsuario() {
            return this.usuarioRegistrado;
        }
    }

    @Test
    void validarRegistroYObtencionUsuario_DebeCoincidirNombreYCorreo() {
        // Arrange
        String nombreEsperado = "Cristian";
        String correoEsperado = "cristian@correo.com";
        String contrasena = "12345";

        // Act
        usuarioService.registrarUsuario(nombreEsperado, correoEsperado, contrasena);
        String usuarioObtenido = usuarioService.obtenerUsuario();

        System.out.println("TEST: Usuario registrado -> " + nombreEsperado + ", " + correoEsperado);
        System.out.println("TEST: Usuario obtenido -> " + usuarioObtenido);

        // Assert
        assertTrue(usuarioObtenido.contains(nombreEsperado), "El nombre debe coincidir");
        assertTrue(usuarioObtenido.contains(correoEsperado), "El correo debe coincidir");
    }

    @Test
    void registrarUsuario_DebeLanzarExcepcionSiCamposSonNulos() {
        assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrarUsuario(null, "correo@test.com", "1234");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrarUsuario("Juan", null, "1234");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrarUsuario("Juan", "correo@test.com", null);
        });

        System.out.println("TEST: Se lanzaron excepciones correctamente al faltar datos.");
    }
}
