package equipo.once.elizabeth.richard.wilson;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.SolicitudInquilinoUseCase;
import org.junit.Assert;
import org.junit.Test;


public class SolicitarPermisoAreaComunDisponibilidad {

  private static final String ACEPTADA = "ACEPTADA";
  private static final String RECHAZADA = "RECHAZADA";

  @Test
  public void inquilinoSolicitaPermisoAreaComun_YSeAcepta(){
    SolicitudInquilinoUseCase useCase = new SolicitudInquilinoUseCase();

    AreaComun areaComun = new AreaComun();
    areaComun.estaDisponible = true;

    useCase.areaComun = areaComun;

    SolicitudInquilino solicitudInquilino = useCase.solicitar();

    Assert.assertEquals(ACEPTADA ,  solicitudInquilino.estatus);

  }

  @Test
  public void inquilinoSolicitaPermisoAreaComun_NoSeAcepta(){
    SolicitudInquilinoUseCase useCase = new SolicitudInquilinoUseCase();

    AreaComun areaComun = new AreaComun();
    areaComun.estaDisponible = false;

    useCase.areaComun = areaComun;

    SolicitudInquilino solicitudInquilino = useCase.solicitar();

    Assert.assertEquals(RECHAZADA ,  solicitudInquilino.estatus);
  }

}
