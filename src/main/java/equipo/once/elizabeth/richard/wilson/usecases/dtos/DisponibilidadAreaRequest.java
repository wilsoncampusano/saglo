package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunRequest;

public class DisponibilidadAreaRequest implements AreaComunRequest{
  public String codigoArea;
  public String fechaSolicitud;

  public static DisponibilidadAreaRequest construirRequest(SolicitudAreaComunForm form) {
    return null;
  }
}
