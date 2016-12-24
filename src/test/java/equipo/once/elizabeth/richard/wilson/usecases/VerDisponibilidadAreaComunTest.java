package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.mocks.AreaComunServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class VerDisponibilidadAreaComunTest {

  @Test
  public void verSiAreaComunEstaDisponibleParaLaFecha(){

    DisponibilidadAreaRequest disponibilidadAreaRequest = new DisponibilidadAreaRequest();

    disponibilidadAreaRequest.codigoArea = "A-piscina";

    disponibilidadAreaRequest.fechaSolicitud = "24-dic-2016";

    DisponibilidadAreaUseCase useCase = new DisponibilidadAreaUseCase();
    useCase.areaComunService = new AreaComunServiceHappyPathMock();

    useCase.request = disponibilidadAreaRequest;

    useCase.solicitar();

    DisponibilidadAreaResponse response =(DisponibilidadAreaResponse) useCase.obtenerRespuesta();

    Assert.assertEquals(true, response.disponible);
    Assert.assertNotNull(response.areaComun);

  }
}
