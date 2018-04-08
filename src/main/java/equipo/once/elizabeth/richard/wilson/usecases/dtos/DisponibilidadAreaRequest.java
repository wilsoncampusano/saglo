package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunRequest;

import java.util.Date;

public class DisponibilidadAreaRequest implements AreaComunRequest{
  public String codigoArea;
  public Date fechaSolicitud;

  public static DisponibilidadAreaRequest construirRequest(SolicitudAreaComunForm form) {
    DisponibilidadAreaRequest disponibilidadAreaRequest = new DisponibilidadAreaRequest();
    disponibilidadAreaRequest.codigoArea = form.getAreaComunCodigo();
    disponibilidadAreaRequest.fechaSolicitud = form.fechaSolicitud;
    return disponibilidadAreaRequest;
  }
}
