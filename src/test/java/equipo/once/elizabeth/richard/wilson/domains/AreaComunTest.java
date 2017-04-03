package equipo.once.elizabeth.richard.wilson.domains;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.*;

public class AreaComunTest {

  @Test
  public void areaComunCodigo(){
    AreaComun areaComun = AreaComun.crear("A-piscina-1","Piscina");

    Assert.assertThat(areaComun.nombre, is("Piscina"));
    Assert.assertThat(areaComun.codigo, is("A-piscina-1"));
  }

  @Test
  public void areaConElMismoCodigoSonIgualesTest() {
    AreaComun piscina = AreaComun.crear("A-piscina-1","Piscina");
    AreaComun otraarea = AreaComun.crear("A-piscina-1","Piscina");

    Assert.assertThat(piscina, is(otraarea));

  }

}
