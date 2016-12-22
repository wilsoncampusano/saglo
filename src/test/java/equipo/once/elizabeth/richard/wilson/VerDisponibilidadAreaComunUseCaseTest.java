package equipo.once.elizabeth.richard.wilson;

import equipo.once.elizabeth.richard.wilson.mocks.AreaComunServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaResponse;
import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaUseCase;
import org.junit.Assert;
import org.junit.Test;

public class VerDisponibilidadAreaComunUseCaseTest {



  @Test
  public void verSiAreaComunEstaDisponibleParaLaFecha(){

    DisponibilidadAreaRequest disponibilidadAreaRequest = new DisponibilidadAreaRequest();

    disponibilidadAreaRequest.codigoArea = "A-piscina";

    disponibilidadAreaRequest.fechaSolicitud = "24-dic-2016";

    DisponibilidadAreaUseCase useCase = new DisponibilidadAreaUseCase();
    useCase.areaComunService = new AreaComunServiceHappyPathMock();

    useCase.request = disponibilidadAreaRequest;

    useCase.solicitar();

    DisponibilidadAreaResponse response = useCase.obtenerRespuesta();

    Assert.assertEquals(true, response.disponible);
    Assert.assertNotNull(response.areaComun);

  }
}
