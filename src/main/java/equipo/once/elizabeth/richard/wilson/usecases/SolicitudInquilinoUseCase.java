package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;

public class SolicitudInquilinoUseCase {

  public AreaComun areaComun;

  public SolicitudInquilino solicitar() {
    SolicitudInquilino solicitudInquilino = new SolicitudInquilino();

    if(areaComun.estaDisponible)
      solicitudInquilino.estatus = "ACEPTADA";
    else
      solicitudInquilino.estatus = "RECHAZADA";

    return solicitudInquilino;
  }
}
