package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.dtos.DisponibilidadAreaResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadAreaComunUseCase implements AreaComunUseCase {
  @Autowired
  public AreaComunService areaComunService;
  public DisponibilidadAreaRequest request;
  public DisponibilidadAreaResponse response;


  public void solicitar() {
    AreaComun areaComun = areaComunService.buscarPorCodigo(request.codigoArea);

    boolean disponibilidad = areaComunService
        .disponibleALafecha(request.codigoArea, request.fechaSolicitud);

    response = new DisponibilidadAreaResponse();

    response.disponible = disponibilidad;
    response.areaComun = areaComun;
  }

  public AreaComunResponse obtenerRespuesta() {
    return response;
  }
}
