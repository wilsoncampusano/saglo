package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.repository.PagoInquilinoRepository;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoInquilinoServiceImpl implements PagoInquilinoService {

  @Autowired
  PagoInquilinoRepository pagoInquilinoRepository;

  @Override
  public List<PagoInquilino> pagosPorInquilino(Inquilino entidad) {
    List<PagoInquilino> pagos = new ArrayList<>();


    return pagos;
  }
}
