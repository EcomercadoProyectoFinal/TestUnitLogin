package org.esfe.repository;

import org.esfe.model.Rol;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository {
    Rol save(Rol rol);
}
