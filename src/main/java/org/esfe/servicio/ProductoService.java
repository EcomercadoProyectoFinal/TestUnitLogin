package org.esfe.servicio;

import org.esfe.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.esfe.model.Producto;

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

    public void eliminarProducto(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        productoRepository.deleteById(id);
    }
}
