package org.esfe.servicio;

import org.esfe.model.Rol;
import org.esfe.repository.RolRepository;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol crearRol(Rol rol) {
        if (rol.getNombre() == null || rol.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacío");
        }
        return rolRepository.save(rol);
    }
}
