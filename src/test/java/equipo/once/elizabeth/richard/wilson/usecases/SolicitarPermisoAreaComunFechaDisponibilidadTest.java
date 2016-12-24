package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

public class SolicitarPermisoAreaComunFechaDisponibilidadTest {

  @Test@Ignore
  public void inquilinoSolicitaAreaComunEnFechaDisponible(){
    SolicitudInquilinoUseCase useCase = new SolicitudInquilinoUseCase();

    AreaComun areaComun = new AreaComun();
    useCase.areaComun = areaComun;

    SolicitudInquilino solicitudInquilino = new SolicitudInquilino();
    solicitudInquilino.fechaSolicitud = new Date();

    solicitudInquilino = useCase.solicitar();

    Assert.assertEquals("ACEPTADA",solicitudInquilino.estatus);


  }
}
