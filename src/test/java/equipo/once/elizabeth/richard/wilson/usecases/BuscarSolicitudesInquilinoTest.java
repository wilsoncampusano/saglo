package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarSolicitudesInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarSolicitudesInquilinoResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class BuscarSolicitudesInquilinoTest {

    @Test
    public void solicitudesDelInquilino(){
        Inquilino richard = new InquilinoMock();
        BuscarSolicitudesInquilinoUseCase useCase = new BuscarSolicitudesInquilinoUseCase();
        BuscarSolicitudesInquilinoRequest request = new BuscarSolicitudesInquilinoRequest();

        request.inquilino = richard;
        request.fechaDesde = "01-01-2017";

        useCase.request = request;

        useCase.solicitar();

        BuscarSolicitudesInquilinoResponse response = (BuscarSolicitudesInquilinoResponse) useCase.obtenerRespuesta();
        List<SolicitudInquilino> solicitudesInquilino = response.solicitudes;
        Assert.assertThat(solicitudesInquilino.size(), is(1));
    }
}
