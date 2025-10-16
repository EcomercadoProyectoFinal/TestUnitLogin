package org.esfe.servicio;

import org.esfe.model.Usuario;
import org.esfe.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getCorreo() == null || usuario.getContrasena() == null) {
            throw new IllegalArgumentException("Los campos del usuario no pueden ser nulos");
        }
        return usuarioRepository.save(usuario);
    }
}
