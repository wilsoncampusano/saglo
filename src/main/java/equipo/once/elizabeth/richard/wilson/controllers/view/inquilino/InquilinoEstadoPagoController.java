package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/inquilino/estados")
public class InquilinoEstadoPagoController extends InquilinoController {
  @Autowired
  PagoInquilinoService pagoInquilinoService;


  private static final String INQUILINO_ESTADOS_PAGOS = "inquilino/estados/pagos";

  @RequestMapping(value = {"/pagos/","/pagos"})
  public ModelAndView inquilinoSolicitudesGet(RedirectAttributes redirectAttrs,
                                              HttpSession httpSession,
                                              Authentication auth){

    ModelAndView modelAndView = new ModelAndView(INQUILINO_ESTADOS_PAGOS);

    Inquilino inquilino = obtenerInquilino(auth);

    List<PagoInquilino> pagos = pagoInquilinoService.pagosPorInquilino(inquilino);
    modelAndView.addObject("pagos", pagos);
    return modelAndView;
  }
}
