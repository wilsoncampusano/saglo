package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/inquilino/perfil")
public class InquilinoPerfilController extends InquilinoController {

  @Autowired
  MobiliarioInquilinoService mobiliarioInquilinoService;


  private static final String INQUILINO_PERFIL = "inquilino/perfil";

  @RequestMapping(value = {"/",""})
  public ModelAndView perfilGet(Authentication authentication){
    ModelAndView modelAndView = new ModelAndView(INQUILINO_PERFIL);

    Inquilino inquilino = obtenerInquilino(authentication);

    MobiliarioInquilino mobiliarioInquilino = mobiliarioInquilinoService.buscar(inquilino);

    modelAndView.addObject("inquilino", inquilino);
    modelAndView.addObject("mobiliarioInquilino", mobiliarioInquilino);

    return modelAndView;
  }
}
