package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;

public class SolicitudInquilinoUseCase {
  public Inquilino inquilino;
  public AreaComun areaComun;

  public SolicitudInquilino solicitar() {
    return new SolicitudInquilino();
  }
}
