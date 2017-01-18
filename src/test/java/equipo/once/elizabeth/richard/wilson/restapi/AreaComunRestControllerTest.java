package equipo.once.elizabeth.richard.wilson.restapi;

import equipo.once.elizabeth.richard.wilson.SagloApplication;
import equipo.once.elizabeth.richard.wilson.controllers.restapi.AreaComunRestController;
import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.services.impl.AreaComunServiceImpl;
import equipo.once.elizabeth.richard.wilson.usecases.BuscarAreaComunUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SagloApplication.class)
@WebAppConfiguration
public class AreaComunRestControllerTest {

  private AreaComunRestController areaComunRestController;
  private AreaComunService areaComunService;
  private BuscarAreaComunUseCase buscarAreaComunUseCase;
  @Autowired
  private AreaComunRepositoryCustom areaComunRepositoryCustom;

  private MockMvc mockMvc;


  @Before
  public void setUp() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/view/");
    viewResolver.setSuffix(".jsp");

    areaComunRestController = new AreaComunRestController();
    buscarAreaComunUseCase = new BuscarAreaComunUseCase();
    areaComunService = new AreaComunServiceImpl();
    AreaComun areaComun = AreaComun.crear("A-piscina-01", "Piscina");

    areaComun = areaComunRepositoryCustom.save(areaComun);

    areaComunService.setAreaComunRepository(areaComunRepositoryCustom);
    buscarAreaComunUseCase.areaComunService = areaComunService;

    areaComunRestController.setBuscarAreaComunUseCase(buscarAreaComunUseCase);

    mockMvc = MockMvcBuilders.standaloneSetup(areaComunRestController)
            .setViewResolvers(viewResolver).build();
  }


  @Test
  public void buscaAreasTest() throws Exception{
    this.mockMvc
        .perform(get("/api/areacomun/buscar").param("palabra", "pis"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.areasComunes[0].nombre", is("Piscina")));
  }
}
