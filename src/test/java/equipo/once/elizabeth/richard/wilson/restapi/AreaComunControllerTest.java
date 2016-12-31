package equipo.once.elizabeth.richard.wilson.restapi;

import equipo.once.elizabeth.richard.wilson.SagloApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SagloApplication.class)
@WebAppConfiguration
public class AreaComunControllerTest {

  @Autowired
  private WebApplicationContext wac ;
  private MockMvc mockMvc;


  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }


  @Test
  public void buscaAreasTest() throws Exception{
    this.mockMvc
        .perform(get("/api/areacomun/buscar").param("palabra", "piscina"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
