package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudCasoAveriaForm;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitudAveriaService {


  List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino);

  void guardar(SolicitudCasoAveriaForm form);

  List<SolicitudAveriaDetalle> buscarTodasLasSolicitudesAveriasPendiente();

  SolicitudAveriaDetalle buscarSolicitudPorId(Long averiaId);


  void asignar(SolicitudAveriaDetalle solicitudAveriaDetalle);

  void cambiarEstado(String proceso, Long solicitudAveriaDetalle);

  List<SolicitudCasoAveria> buscarPendientesAsignadasA(Tecnico tecnico);

  void comentario(String comentario, Long id);
}
