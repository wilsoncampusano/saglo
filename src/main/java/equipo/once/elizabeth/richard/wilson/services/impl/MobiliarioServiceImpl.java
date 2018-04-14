package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.repository.MobiliarioRepository;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobiliarioServiceImpl implements MobiliarioService {

  @Autowired
  MobiliarioRepository mobiliarioRepository;

  @Override
  public MobiliarioInquilino buscarPorInquilino(Inquilino inquilino) {
    return null;
  }
}
