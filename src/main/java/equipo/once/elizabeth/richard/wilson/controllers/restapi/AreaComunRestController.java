package equipo.once.elizabeth.richard.wilson.controllers.restapi;

import equipo.once.elizabeth.richard.wilson.usecases.BuscarAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaComunRestController extends RestApiController {

  @Autowired
  private BuscarAreaComunUseCase buscarAreaComunUseCase;

  @RequestMapping(value = "areacomun/buscar")
  public
  @ResponseBody
  AreaComunResponse buscarAreasComunesDisponigles(
      @RequestParam(value = "palabra") String palabraBusqueda){

    BuscarAreaComunRequest request = new BuscarAreaComunRequest();
    request.palabraBusqueda = palabraBusqueda;
    buscarAreaComunUseCase.request = request;
    buscarAreaComunUseCase.solicitar();
    return buscarAreaComunUseCase.obtenerRespuesta();
  }

  public void setBuscarAreaComunUseCase(BuscarAreaComunUseCase buscarAreaComunUseCase) {
    this.buscarAreaComunUseCase = buscarAreaComunUseCase;
  }
}
