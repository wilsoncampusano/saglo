package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.repository.InquilinoRepository;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquilinoServiceImpl implements InquilinoService {

  @Autowired
  private InquilinoRepository inquilinoRepository;


  @Override
  public Inquilino buscarPorUsuario(Usuario usuario) {

    Inquilino inquilino = inquilinoRepository.bucarPorUsuario(usuario.username);
    return inquilino;
  }
}
