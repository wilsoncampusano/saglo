package equipo.once.elizabeth.richard.wilson.repositories;

import equipo.once.elizabeth.richard.wilson.repository.InquilinoRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class InquilinoRepositoryTest {

  @Autowired
  InquilinoRepositoryCustom repository;


  @Before
  public void conInquilino(){
    Inquilino inquilino = new Inquilino();
    inquilino.codigo =  "I-wilson-01";
    repository.save(inquilino);
  }

  @Test
  public void puedeBuscarInquilinoPorCodigo() {
    Inquilino inquilino = repository.findByCodigo("I-wilson-01");
    Inquilino wilson = new Inquilino();
    wilson.codigo = "I-wilson-01";

    Assert.assertThat(inquilino, is(wilson));
  }
}
