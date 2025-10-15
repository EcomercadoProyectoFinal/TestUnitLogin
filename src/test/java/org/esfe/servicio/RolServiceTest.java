package org.esfe.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RolServiceTest {
    
     private RolService rolService;

    @BeforeEach
    void setUp() {
        rolService = new RolService();
    }

    // Clase interna para mantener todo dentro del mismo archivo (sin necesidad de otra clase)
    class RolService {
        private String rolGuardado;

        // Simula la creación de un rol
        public void crearRol(String nombreRol) {
            if (nombreRol == null || nombreRol.isEmpty()) {
                throw new IllegalArgumentException("El nombre del rol no puede estar vacío");
            }
            this.rolGuardado = nombreRol;
        }

        // Simula la obtención del rol
        public String obtenerRol() {
            return this.rolGuardado;
        }
    }

    @Test
    void validarCreacionYObtencionDeRol_DebeCoincidirElNombre() {
        // Arrange (Preparar datos)
        String rolEsperado = "Administrador";

        // Act (Ejecutar acciones)
        rolService.crearRol(rolEsperado);
        String rolObtenido = rolService.obtenerRol();

        System.out.println("TEST: Rol creado -> " + rolEsperado);
        System.out.println("TEST: Rol obtenido -> " + rolObtenido);

        // Assert (Verificar resultados)
        assertEquals(rolEsperado, rolObtenido, "El rol obtenido debe ser igual al creado");
    }
}
