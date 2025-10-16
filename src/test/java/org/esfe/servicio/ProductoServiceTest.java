package org.esfe.servicio;

import org.esfe.model.Producto;
import org.esfe.repository.ProductoRepository;

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

    System.out.println("TEST: Producto creado -> " + productoEsperado.getNombre());
    System.out.println("TEST: Producto obtenido -> " + productoObtenido.getNombre());

    assertEquals(productoEsperado.getNombre(), productoObtenido.getNombre());
    verify(productoRepository, times(1)).save(any(Producto.class));
}

}
