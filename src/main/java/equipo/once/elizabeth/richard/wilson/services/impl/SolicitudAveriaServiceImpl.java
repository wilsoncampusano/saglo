package equipo.once.elizabeth.richard.wilson.services.impl;


import equipo.once.elizabeth.richard.wilson.entities.dao.SolicitudAveriaRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudAveriaServiceImpl implements SolicitudAveriaService{

  @Autowired
  SolicitudAveriaRepository solicitudAveriaRepository;

  @Override
  public List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino) {
    List<SolicitudCasoAveria> solicitudCasoAverias =
        solicitudAveriaRepository.buscarSolicitudesDelInquilino(inquilino.id);

    return new ArrayList<>();
  }
}
