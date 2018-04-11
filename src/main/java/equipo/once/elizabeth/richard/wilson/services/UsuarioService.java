package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.seguridad.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    void guardar(Usuario usuario);

    Usuario buscarPorUsername(String username);
}
