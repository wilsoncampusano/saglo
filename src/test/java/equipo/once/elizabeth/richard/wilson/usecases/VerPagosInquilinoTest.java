package equipo.once.elizabeth.richard.wilson.usecases;


import equipo.once.elizabeth.richard.wilson.mocks.InquilinoServiceUnPagoMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class VerPagosInquilinoTest {

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
}
