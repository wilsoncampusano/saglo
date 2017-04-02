package equipo.once.elizabeth.richard.wilson.repositories;

import equipo.once.elizabeth.richard.wilson.entities.dao.InquilinoRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import org.hamcrest.core.Is;
import org.junit.Assert;
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
  InquilinoRepositoryCustom inquilinoRespositoryCustom;

  @Test
  public void puedeBuscarInquilinoPorCodigo() {
    Inquilino inquilino = inquilinoRespositoryCustom.findByCodigo("I-wilson-01");

    Assert.assertThat(inquilino.nombres, is("Wilson"));
    Assert.assertThat(inquilino.apellidos, is("Campusano Jorge"));
  }
}
