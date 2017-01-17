package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.services.SolicitudInquilinoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudInquilinoAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudInquilinoAreaComunResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.UseCaseResponse;

public class SolicitudInquilinoAreaComunUseCase implements InquilinoUseCase{
  public SolicitudInquilinoAreaComunRequest request;
  private SolicitudInquilinoAreaComunResponse response;
  public SolicitudInquilinoService solicitudInquilinoService;

  public void solicitar() {
    response = new SolicitudInquilinoAreaComunResponse();
    response.solicitud = solicitudInquilinoService.guardar(request.form);
    response.form = request.form;
  }

  @Override
  public UseCaseResponse obtenerRespuesta() {
    return response;
  }
}
