package equipo.once.elizabeth.richard.wilson.domains;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class AreaComunTest {

  @Test
  public void areaComunCodigo(){
    AreaComun areaComun = AreaComun.crear("A-piscina-1","Piscina");

    Assert.assertThat(areaComun.nombre, Is.is("Piscina"));
    Assert.assertThat(areaComun.codigo, Is.is("A-piscina-1"));
  }
}
