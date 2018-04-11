package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface InquilinoService {
  Inquilino buscarPorUsuario(Usuario usuario);
}
