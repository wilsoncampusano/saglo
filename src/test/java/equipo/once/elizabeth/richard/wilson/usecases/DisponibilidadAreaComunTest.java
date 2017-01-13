package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.mocks.AreaComunServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaResponse;
import org.junit.Assert;
import org.junit.Test;

public class DisponibilidadAreaComunTest {

  @Test
  public void verSiAreaComunEstaDisponibleParaLaFecha(){

    DisponibilidadAreaRequest disponibilidadAreaRequest = new DisponibilidadAreaRequest();

    disponibilidadAreaRequest.codigoArea = "A-piscina";

    disponibilidadAreaRequest.fechaSolicitud = "24-12-2016";

    DisponibilidadAreaComunUseCase useCase = new DisponibilidadAreaComunUseCase();
    useCase.areaComunService = new AreaComunServiceHappyPathMock();

    useCase.request = disponibilidadAreaRequest;

    useCase.solicitar();

    DisponibilidadAreaResponse response =(DisponibilidadAreaResponse) useCase.obtenerRespuesta();

    Assert.assertEquals(true, response.disponible);
    Assert.assertNotNull(response.areaComun);

  }
}
