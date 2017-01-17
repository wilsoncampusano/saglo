package equipo.once.elizabeth.richard.wilson.usecases.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import equipo.once.elizabeth.richard.wilson.mocks.SolicitudInquilinoServiceUnaSolicitudMock;
import equipo.once.elizabeth.richard.wilson.usecases.BuscarSolicitudesInquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarSolicitudesInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarSolicitudesInquilinoResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class BuscarSolicitudesInquilinoTest {

    private Inquilino richard;
    private BuscarSolicitudesInquilinoUseCase useCase;
    private BuscarSolicitudesInquilinoRequest request;

    @Before
    public void conSolicitudAsignadaAUnInquilino(){
        richard = new InquilinoMock();
        useCase = new BuscarSolicitudesInquilinoUseCase();
        request = new BuscarSolicitudesInquilinoRequest();
        useCase.solicitudInquilinoService = new SolicitudInquilinoServiceUnaSolicitudMock();

        request.inquilino = richard;
        request.fechaDesde = "01-01-2017";
    }

    @Test
    public void lasSolicitudesPertenecenAlInquilinoActual() {
        useCase.request = request;

        Inquilino otroInquilino = new InquilinoMock();
        otroInquilino.setCodigo("I-otro-01");

        useCase.solicitar();

        BuscarSolicitudesInquilinoResponse response = (BuscarSolicitudesInquilinoResponse) useCase.obtenerRespuesta();
        List<SolicitudInquilino> solicitudesInquilino = response.solicitudes;
        Assert.assertThat(solicitudesInquilino.size(), is(1));
        Assert.assertThat(solicitudesInquilino.stream().findAny().get().inquilino, is(richard));
        Assert.assertThat(solicitudesInquilino.stream().findAny().get().inquilino, is(not(otroInquilino)));
    }
}
