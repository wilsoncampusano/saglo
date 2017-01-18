package equipo.once.elizabeth.richard.wilson.restapi;

import equipo.once.elizabeth.richard.wilson.SagloApplication;
import equipo.once.elizabeth.richard.wilson.controllers.restapi.AreaComunRestController;
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
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SagloApplication.class)
@WebAppConfiguration
public class AreaComunRestControllerTest {

  @Autowired
  private WebApplicationContext wac ;

  @Autowired
  AreaComunRestController areaComunRestController;
  private MockMvc mockMvc;


  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(areaComunRestController).build();
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
