package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wicampusano on 1/5/2017.
 */
@Controller
@RequestMapping(value = "/inquilino/perfil")
public class InquilinoPerfilController extends InquilinoController {


  private static final String INQUILINO_PERFIL = "/inquilino/perfil";

  @RequestMapping(value = {"/",""})
  public ModelAndView perfilGet(){
    ModelAndView modelAndView = new ModelAndView(INQUILINO_PERFIL);
    
    return modelAndView;
  }
}
