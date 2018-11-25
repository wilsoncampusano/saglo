package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import equipo.once.elizabeth.richard.wilson.dtos.FormRegistroPago;
import equipo.once.elizabeth.richard.wilson.dtos.InquilinoPagoDto;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.services.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/admin/estados")
public class AdminPagoEstadoRegistrarController extends AdminController {
  private static final String ADMIN_PAGOS_REGISTRAR = "admin/estados/pagos/registrar";
  @Autowired
  InquilinoService inquilinoService;


  @RequestMapping(value = {"/pagos/registrar","/pagos/registrar/"})
  public ModelAndView solicitudesAveria(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(ADMIN_PAGOS_REGISTRAR);

    List<InquilinoPagoDto> inquilinos = inquilinoService.inquilinosMobiliario();


    FormRegistroPago formRegistroPago = new FormRegistroPago();

    modelAndView.addObject("inquilinosDto", inquilinos);
    modelAndView.addObject("form", formRegistroPago);
    return modelAndView;
  }
}
