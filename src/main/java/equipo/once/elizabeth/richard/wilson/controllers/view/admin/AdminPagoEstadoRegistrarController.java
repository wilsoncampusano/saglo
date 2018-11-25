package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/admin/estados")
public class AdminPagoEstadoRegistrarController extends AdminController {
  private static final String ADMIN_PAGOS_REGISTRAR = "admin/estados/pagos/registrar";


  @RequestMapping(value = {"/pagos/registrar","/pagos/registrar/"})
  public ModelAndView solicitudesAveria(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(ADMIN_PAGOS_REGISTRAR);


    return modelAndView;
  }
}
