package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarAreaComunResponse;

import java.util.List;

public class BuscarAreaComunUseCase {
  public AreaComunService areaComunService;
  public BuscarAreaComunRequest request;
  private BuscarAreaComunResponse response;

  public void solicitar() {
    List<AreaComun> areasComunes =
        areaComunService.buscarPorPalabra(request.palabraBusqueda);

    BuscarAreaComunResponse response = new BuscarAreaComunResponse();

    response.areasComunes = areasComunes;
    this.response = response;

  }

  public BuscarAreaComunResponse obtenerRespuesta() {
    return response;
  }
}
