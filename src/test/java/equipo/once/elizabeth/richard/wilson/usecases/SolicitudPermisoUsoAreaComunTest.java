package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudInquilinoAreaComunRequest;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
        useCase.request = request;


        assertThat(useCase.request.form.areaComun, is(NOT_NULL));
        assertThat(useCase.request.form.fechaSolicitud, is("01-01-2016"));
        assertThat(useCase.request.form.comentario, is(NOT_NULL));
    }
}
