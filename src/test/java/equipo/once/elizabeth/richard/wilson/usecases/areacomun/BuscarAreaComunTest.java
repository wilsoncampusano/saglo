package equipo.once.elizabeth.richard.wilson.usecases.areacomun;

import equipo.once.elizabeth.richard.wilson.mocks.AreaComunServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.BuscarAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarAreaComunResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
public class BuscarAreaComunTest {

  @Test
  public void buscaAreaComunPorNombre(){
    String nombre = "piscina";
    BuscarAreaComunUseCase useCase = new BuscarAreaComunUseCase();
    BuscarAreaComunRequest request = new BuscarAreaComunRequest();

    request.palabraBusqueda = nombre;
    useCase.areaComunService = new AreaComunServiceHappyPathMock();
    useCase.request = request;

    useCase.solicitar();

    BuscarAreaComunResponse response = (BuscarAreaComunResponse)useCase.obtenerRespuesta();

    Assert.assertThat(response.areasComunes.size(), is(1));
  }
}
