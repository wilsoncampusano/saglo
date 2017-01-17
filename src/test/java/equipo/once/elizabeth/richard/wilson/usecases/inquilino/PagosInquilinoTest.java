package equipo.once.elizabeth.richard.wilson.usecases.inquilino;



import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoServiceUnPagoMock;
import equipo.once.elizabeth.richard.wilson.usecases.PagosInquilinoFechaUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


public class PagosInquilinoTest {

    private Inquilino inquilino;
    private PagoInquilinoRequest request;
    private PagosInquilinoFechaUseCase useCase;


    @Before
    public void setUp(){
        request = new PagoInquilinoRequest();
        inquilino = new InquilinoMock();

        request.fechaInicio = "01-06-2019";
        request.estado = "completado";
        request.entidad = inquilino;

        useCase = new PagosInquilinoFechaUseCase();
        useCase.pagoInquilinoService = new InquilinoServiceUnPagoMock();
    }

    @Test
    public void pagosPertenecenAlInquilinoSolicitado(){

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(1));
    }

    @Test
    public void pagosRealizados(){

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(1));
    }

    @Test
    public void pagosPendientes(){
        request.estado = "pendiente";

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(0));
    }
}
