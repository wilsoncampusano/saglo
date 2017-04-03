package equipo.once.elizabeth.richard.wilson.repositories;

import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.hamcrest.core.IsNot;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.*;
import static org.mockito.internal.matchers.NotNull.NOT_NULL;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class AreaComunRespositoryTest{

    @Autowired
    AreaComunRepositoryCustom repository;

    @Before
    public void conUnAreaInsertada() {
        AreaComun areaComun = AreaComun.crear("A-piscina-01", "Piscina");
        repository.save(areaComun);
    }

    @Test
    public void puedeBuscarTodasLasAreascomunesTest() {
        Iterable<AreaComun> all = repository.findAll();

        List<AreaComun> areaComuns = new ArrayList<>();
        all.forEach(a -> areaComuns.add(a));


        Assert.assertThat(all, is(NOT_NULL));
        Assert.assertThat(areaComuns.size(), not(0));
    }
}