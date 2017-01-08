package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/inquilino/estados/")
public class InquilinoSolicitudesController extends InquilinoController{

  private static final String INQUILINO_ESTADOS_SOLICITUDES = "/inquilino/estados/solicitudes";

  @RequestMapping(value = {"/solicitudes/","solicitudes"})
  public ModelAndView inquilinoSolicitudesGet(){
    ModelAndView modelAndView = new ModelAndView(INQUILINO_ESTADOS_SOLICITUDES);
    return modelAndView;
  }
}
