package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioService;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarMobiliarioInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarMobiliarioInquilinoResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;

public class BuscarMobiliarioInquilinoUseCase implements InquilinoUseCase {

  public BuscarMobiliarioInquilinoRequest request;
  public BuscarMobiliarioInquilinoResponse response;
  public MobiliarioService mobiliarioService;

  public void solicitar() {
    MobiliarioInquilino mobiliarioInquilino;
    mobiliarioInquilino = mobiliarioService.buscarPorInquilino(request.inquilino);
    response = new BuscarMobiliarioInquilinoResponse();
    response.mobiliario = mobiliarioInquilino;
  }

  public BuscarMobiliarioInquilinoResponse obtenerRespuesta() {
    return this.response;
  }
}
