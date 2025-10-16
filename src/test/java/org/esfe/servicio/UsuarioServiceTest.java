package org.esfe.servicio;

import org.esfe.model.Usuario;
import org.esfe.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registrarUsuario_DebeGuardarYDevolverUsuario() {
        Usuario usuarioEsperado = new Usuario("Cristian", "cristian@correo.com", "12345");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioEsperado);

        Usuario usuarioObtenido = usuarioService.registrarUsuario(usuarioEsperado);

        System.out.println("TEST: Usuario registrado -> " + usuarioEsperado.getNombre() + ", " + usuarioEsperado.getCorreo());
        System.out.println("TEST: Usuario obtenido -> " + usuarioObtenido.getNombre() + ", " + usuarioObtenido.getCorreo());

        assertEquals(usuarioEsperado.getNombre(), usuarioObtenido.getNombre());
        assertEquals(usuarioEsperado.getCorreo(), usuarioObtenido.getCorreo());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

}
