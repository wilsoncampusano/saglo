package equipo.once.elizabeth.richard.wilson.repositories;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class SolicitudAreacomunRepositoryTest {


  @Test @Ignore
  public void puedeInsertarUnaSolicitudTest() {
    SolicitudAreacomun solicitudAreacomun = new SolicitudAreacomun();

  }
}
