package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.service.AreaComunService;

public class SolicitudInquilinoUseCase {

  public AreaComun areaComun;
  private AreaComunService areaComunService;

  public SolicitudInquilino solicitar() {
    SolicitudInquilino solicitudInquilino = new SolicitudInquilino();

    areaComunService.buscarDisponibilidad(areaComun, solicitudInquilino);

    if(areaComun.estaDisponible)
      solicitudInquilino.estatus = "ACEPTADA";
    else
      solicitudInquilino.estatus = "RECHAZADA";

    return solicitudInquilino;
  }
}
