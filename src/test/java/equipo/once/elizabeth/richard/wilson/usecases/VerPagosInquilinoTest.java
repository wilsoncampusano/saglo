package equipo.once.elizabeth.richard.wilson.usecases;



import equipo.once.elizabeth.richard.wilson.entities.dominio.Entidad;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoServiceUnPagoMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class VerPagosInquilinoTest {

    @Test
    public void pagosPertenecenAlInquilinoSolicitado(){
        PagoInquilinoRequest request = new PagoInquilinoRequest();
        Entidad richard = new InquilinoMock();
        richard.setCodigo("I-richard-01");

        request.fechaInicio = "01-06-2019";
        request.estado = "completado";
        request.entidad = richard;

        PagosInquilinoFechaUseCase useCase = new PagosInquilinoFechaUseCase();
        useCase.pagoInquilinoService = new InquilinoServiceUnPagoMock();

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(1));
    }

    @Test
    public void pagosRealizados(){

       PagoInquilinoRequest request = new PagoInquilinoRequest();

        request.fechaInicio = "01-06-2019";
        request.estado = "completado";

        PagosInquilinoFechaUseCase useCase = new PagosInquilinoFechaUseCase();
        useCase.pagoInquilinoService = new InquilinoServiceUnPagoMock();

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(1));
    }

    @Test
    @Ignore
    public void pagosPendientes(){
        PagoInquilinoRequest request = new PagoInquilinoRequest();
        request.fechaInicio = "01-06-2016";
        request.estado = "pendiente";

        PagosInquilinoFechaUseCase useCase = new PagosInquilinoFechaUseCase();
        useCase.pagoInquilinoService = new InquilinoServiceUnPagoMock();

        useCase.request = request;

        useCase.solicitar();

        PagoInquilinoResponse response = (PagoInquilinoResponse) useCase.obtenerRespuesta();

        Assert.assertThat(response.pagos.size(), is(0));
    }
}
