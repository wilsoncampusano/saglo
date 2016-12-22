package equipo.once.elizabeth.richard.wilson;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.service.AreaComunService;

public class AreaComunServiceHappyPathMock implements AreaComunService {
  @Override
  public void buscarDisponibilidad(AreaComun areaComun, SolicitudInquilino solicitudInquilino) {
  }

  @Override
  public boolean disponibleALafecha(String codigoArea, String fechaSolicitud) {
    return true;
  }

  @Override
  public AreaComun buscarPorCodigo(String codigoArea) {
    return null;
  }
}
