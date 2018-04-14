package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.repository.MobiliarioInquilinoRepository;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobiliarioInquilinoServiceImpl implements MobiliarioInquilinoService {
  @Autowired
  MobiliarioInquilinoRepository mobiliarioInquilinoRepository;
  @Override
  public MobiliarioInquilino buscar(Inquilino inquilino) {
    return mobiliarioInquilinoRepository.buscar(inquilino.id);
  }
}
