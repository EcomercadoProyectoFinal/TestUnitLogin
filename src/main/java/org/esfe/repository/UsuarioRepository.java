package org.esfe.repository;

import org.esfe.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository {
    Usuario save(Usuario usuario);
}
