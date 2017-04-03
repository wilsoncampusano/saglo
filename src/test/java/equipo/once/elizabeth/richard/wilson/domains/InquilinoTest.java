package equipo.once.elizabeth.richard.wilson.domains;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.mocks.InquilinoMock;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class InquilinoTest {


  @Test
  public void inquilinosConElMismoCodigoSonIguales(){
    Inquilino richard = new Inquilino();
    Inquilino inquilino = new Inquilino();

    richard.codigo = "I-richard-01";
    inquilino.codigo = "I-richard-01";

    Assert.assertThat(inquilino, Is.is(richard));
  }
}
