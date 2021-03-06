package equipo.once.elizabeth.richard.wilson.usecases.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import equipo.once.elizabeth.richard.wilson.mocks.MobiliarioServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.BuscarMobiliarioInquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarMobiliarioInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarMobiliarioInquilinoResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BuscarMobiliarioInquilinoTest {

  @Test
  public void buscaElMobiliarioAsignadoAlInquilino(){
    Inquilino inquilino = new Inquilino();
    inquilino.codigo = InquilinoMock.CODIGO_INQUILINO_MOCK;

    BuscarMobiliarioInquilinoRequest request = new BuscarMobiliarioInquilinoRequest();

    BuscarMobiliarioInquilinoUseCase useCase = new BuscarMobiliarioInquilinoUseCase();
    useCase.mobiliarioService = new MobiliarioServiceHappyPathMock();

    request.inquilino = inquilino;
    useCase.request = request;

    useCase.solicitar();

    BuscarMobiliarioInquilinoResponse response = useCase.obtenerRespuesta();

    assertThat(response.mobiliario.inquilino , is(inquilino));
  }
}
