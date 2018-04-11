package equipo.once.elizabeth.richard.wilson.usecases.areacomun;

import equipo.once.elizabeth.richard.wilson.mocks.AreaComunServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.dtos.DisponibilidadAreaResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DisponibilidadAreaComunTest {

  @Test
  public void verSiAreaComunEstaDisponibleParaLaFecha(){

    DisponibilidadAreaRequest disponibilidadAreaRequest = new DisponibilidadAreaRequest();

    disponibilidadAreaRequest.codigoArea = "A-piscina";

    disponibilidadAreaRequest.fechaSolicitud = new Date();

    DisponibilidadAreaComunUseCase useCase = new DisponibilidadAreaComunUseCase();
    useCase.areaComunService = new AreaComunServiceHappyPathMock();

    useCase.request = disponibilidadAreaRequest;

    useCase.solicitar();

    DisponibilidadAreaResponse response =(DisponibilidadAreaResponse) useCase.obtenerRespuesta();

    Assert.assertEquals(true, response.disponible);
    Assert.assertNotNull(response.areaComun);

  }
}
