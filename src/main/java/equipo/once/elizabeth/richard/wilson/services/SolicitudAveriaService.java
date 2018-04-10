package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudCasoAveriaForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitudAveriaService {


  List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino);

  void guardar(SolicitudCasoAveriaForm form);
}
