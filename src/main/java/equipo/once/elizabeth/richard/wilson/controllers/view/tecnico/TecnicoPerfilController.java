package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tecnico")
public class TecnicoPerfilController extends TecnicoController {

  @Autowired
  TecnicoService tecnicoService;

  private static final String TECNICO_PERFIL = "tecnico/perfil";

  @RequestMapping(value = {"/perfil/","/perfil"})
  public ModelAndView perfilGet(Authentication authentication){
    ModelAndView modelAndView = new ModelAndView(TECNICO_PERFIL);

    Tecnico tecnico = obtenerTecnico(authentication);


    modelAndView.addObject("tecnico", tecnico);

    return modelAndView;
  }
}
