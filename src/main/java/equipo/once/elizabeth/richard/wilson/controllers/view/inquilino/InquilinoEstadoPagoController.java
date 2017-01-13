package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/inquilino/estados")
public class InquilinoEstadoPagoController extends InquilinoController {


  private static final String INQUILINO_ESTADOS_PAGOS = "/inquilino/estados/pagos";

  @RequestMapping(value = {"/pagos/","/pagos"})
  public ModelAndView inquilinoSolicitudesGet(){
    ModelAndView modelAndView = new ModelAndView(INQUILINO_ESTADOS_PAGOS);
    return modelAndView;
  }
}
