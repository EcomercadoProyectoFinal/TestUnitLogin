package org.esfe.servicio;

import org.esfe.model.Producto;
import org.esfe.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

     private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("Datos inválidos");
        }
        return productoRepository.save(producto);
    }
}
