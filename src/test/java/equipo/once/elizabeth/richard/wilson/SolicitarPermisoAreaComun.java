package equipo.once.elizabeth.richard.wilson;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.SolicitudInquilinoUseCase;
import org.junit.Assert;
import org.junit.Test;


public class SolicitarPermisoAreaComun {

  private static final String ACEPTADA = "ACEPTADA";

  @Test
  public void inquilinoSolicitaPermisoAreaComun(){
    SolicitudInquilinoUseCase useCase = new SolicitudInquilinoUseCase();
    useCase.inquilino = new Inquilino();
    useCase.areaComun = new AreaComun();

    SolicitudInquilino solicitudInquilino = useCase.solicitar();

    Assert.assertEquals(ACEPTADA ,  solicitudInquilino.estatus);

  }

}
