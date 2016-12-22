package equipo.once.elizabeth.richard.wilson.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalesController {

  @RequestMapping(name = "/locales/registrar", method = RequestMethod.GET)
  public  ModelAndView getRegistrarLocal(){
    ModelAndView modelAndView = new ModelAndView("/admin/locales/registrar");
    return modelAndView;
  }
}
