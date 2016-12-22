package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.service.AreaComunService;

public class DisponibilidadAreaUseCase {

  public DisponibilidadAreaRequest request;
  public DisponibilidadAreaResponse response;

  public AreaComunService areaComunService;

  public void solicitar() {
    AreaComun areaComun = areaComunService.buscarPorCodigo(request.codigoArea);

    boolean disponibilidad = areaComunService
        .disponibleALafecha(request.codigoArea, request.fechaSolicitud);

    response = new DisponibilidadAreaResponse();

    response.disponible = disponibilidad;
    response.areaComun = areaComun;
  }

  public DisponibilidadAreaResponse obtenerRespuesta() {
    return response;
  }
}
