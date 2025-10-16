package org.esfe.servicio;

import org.esfe.model.Producto;
import org.esfe.repository.ProductoRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearProducto_DebeGuardarYDevolverProducto() {
        Producto productoEsperado = new Producto("Laptop", 800, "Laptop HP", 5, "Tecnología", "img.jpg");
        when(productoRepository.save(any(Producto.class))).thenReturn(productoEsperado);

        Producto productoObtenido = productoService.crearProducto(productoEsperado);

        assertEquals(productoEsperado.getNombre(), productoObtenido.getNombre());
        verify(productoRepository, times(1)).save(any(Producto.class));
    }

    @Test
    void eliminarProducto_DebeLlamarRepositorioUnaVez() {
        Long idProducto = 1L;

        productoService.eliminarProducto(idProducto);

        verify(productoRepository, times(1)).deleteById(idProducto);
        System.out.println("TEST: Se llamó correctamente a deleteById(" + idProducto + ")");
    }

    @Test
    void eliminarProducto_DebeLanzarExcepcionSiIdInvalido() {
        assertThrows(IllegalArgumentException.class, () -> productoService.eliminarProducto(null));
        assertThrows(IllegalArgumentException.class, () -> productoService.eliminarProducto(0L));

        System.out.println("TEST: Se lanzaron excepciones correctamente por ID inválido");
    }
}
