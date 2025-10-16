package org.esfe.repository;

import org.esfe.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository {
    Producto save(Producto producto);
}
