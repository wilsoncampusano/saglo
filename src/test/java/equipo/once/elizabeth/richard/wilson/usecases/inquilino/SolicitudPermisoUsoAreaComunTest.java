package equipo.once.elizabeth.richard.wilson.usecases.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.mocks.SolicitudInquilinoServiceUnaSolicitudMock;
import equipo.once.elizabeth.richard.wilson.usecases.SolicitudInquilinoAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudInquilinoAreaComunRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudInquilinoAreaComunResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.internal.matchers.NotNull.NOT_NULL;

public class SolicitudPermisoUsoAreaComunTest {


    @Test
    public void solicitaAreaComunDisponible(){
        SolicitudAreaComunForm form = new SolicitudAreaComunForm();
        SolicitudInquilinoAreaComunUseCase useCase = new SolicitudInquilinoAreaComunUseCase();
        SolicitudInquilinoAreaComunRequest request = new SolicitudInquilinoAreaComunRequest();
        AreaComun areaComun = new AreaComun();

        form.areaComun = areaComun;
        form.fechaSolicitud = "01-01-2016";
        form.comentario  = "comentario";

        request.form = form;
        useCase.solicitudInquilinoService = new SolicitudInquilinoServiceUnaSolicitudMock();;
        useCase.request = request;

        useCase.solicitar();

        SolicitudInquilinoAreaComunResponse useCaseResponse = (SolicitudInquilinoAreaComunResponse)
                useCase.obtenerRespuesta();

        assertThat(useCaseResponse.form.areaComun, is(NOT_NULL));
        assertThat(useCaseResponse.form.fechaSolicitud, is("01-01-2016"));
        assertThat(useCaseResponse.form.comentario, is(NOT_NULL));
        assertThat(useCaseResponse.solicitud, is(NOT_NULL));
        assertThat(useCaseResponse.solicitud.getCodigo(), is(not("")));
    }
}
