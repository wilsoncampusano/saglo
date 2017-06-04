package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexTecnicoController extends TecnicoController{

  @RequestMapping(value = {"/","","/index", "home"}, method = RequestMethod.GET)
  public ModelAndView tecnicoIndexGet(){
    ModelAndView modelAndView = new ModelAndView(TECNICO_INDEX_VIEW);

    return modelAndView;
  }
}
