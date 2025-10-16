package org.esfe.servicio;

import org.esfe.model.Rol;
import org.esfe.repository.RolRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RolServiceTest {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRol_DebeGuardarYDevolverRol() {
        Rol rolEsperado = new Rol("Administrador", "Rol con todos los permisos");

        when(rolRepository.save(any(Rol.class))).thenReturn(rolEsperado);

        Rol rolObtenido = rolService.crearRol(rolEsperado);

        System.out.println("TEST: Rol creado -> " + rolEsperado.getNombre());
        System.out.println("TEST: Rol obtenido -> " + rolObtenido.getNombre());

        assertEquals(rolEsperado.getNombre(), rolObtenido.getNombre());
        verify(rolRepository, times(1)).save(any(Rol.class));
    }
}
