package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.Mensaje;
import equipo.once.elizabeth.richard.wilson.dtos.FormRegistroPago;
import equipo.once.elizabeth.richard.wilson.dtos.InquilinoPagoDto;
import equipo.once.elizabeth.richard.wilson.dtos.PagoInquilinoDTO;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.InquilinoService;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping(value = "/admin/estados")
public class AdminPagoEstadoRegistrarController extends AdminController {
  private static final String ADMIN_PAGOS_REGISTRAR = "admin/estados/pagos/registrar";
  private static final String PAGO_LISTADO = "admin/estados/pagos/pagosListado";
  @Autowired
  InquilinoService inquilinoService;

  @Autowired
  PagoInquilinoService pagoInquilinoService;


  @RequestMapping(value = {"/pagos/registrar","/pagos/registrar/"})
  public ModelAndView solicitudesAveria(@RequestParam(name = "exito", required = false) String exito,
                                        Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(ADMIN_PAGOS_REGISTRAR);

    if(Objects.nonNull(exito) && exito.equals("true")){

      Mensaje mensaje = Mensaje.EXITO;
      mensaje.setMensaje("Pago Registrado!");

      modelAndView.addObject(MENSAJE_KEY, mensaje);

    }

    List<InquilinoPagoDto> inquilinos = inquilinoService.inquilinosMobiliario();


    FormRegistroPago formRegistroPago = new FormRegistroPago();

    modelAndView.addObject("inquilinosDto", inquilinos);
    modelAndView.addObject("form", formRegistroPago);
    return modelAndView;
  }


  @RequestMapping(value = {"/pagos/registrar","/pagos/registrar/"}, params = {"registrar"})
  public String postPago(FormRegistroPago pago, Authentication authentication,
                         RedirectAttributes redirectAttributes){


    ModelAndView modelAndView = new ModelAndView(ADMIN_PAGOS_REGISTRAR);

    pagoInquilinoService.registrar(pago);


    redirectAttributes.addAttribute("exito", "true");

    return "redirect:/admin/estados/pagos/registrar";
  }



  @RequestMapping(value = {"/pagos/listado","/pagos/listado/"})
  public ModelAndView listadoPagos(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(PAGO_LISTADO);

    List<PagoInquilinoDTO> pagoInquilinos = pagoInquilinoService.registrados();
    modelAndView.addObject("pagos", pagoInquilinos);
    return modelAndView;
  }
}
