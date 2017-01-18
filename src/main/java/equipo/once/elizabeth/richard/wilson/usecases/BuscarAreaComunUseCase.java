package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarAreaComunResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarAreaComunUseCase implements AreaComunUseCase {
  @Autowired
  public AreaComunService areaComunService;
  public BuscarAreaComunRequest request;
  private BuscarAreaComunResponse response;

  @Override
  public void solicitar() {
    List<AreaComun> areasComunes =
        areaComunService.buscarPorPalabra(request.palabraBusqueda.toLowerCase());

    BuscarAreaComunResponse response = new BuscarAreaComunResponse();

    response.areasComunes = areasComunes;
    this.response = response;

  }

  @Override
  public AreaComunResponse obtenerRespuesta() {
    return response;
  }
}
