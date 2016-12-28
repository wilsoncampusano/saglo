package equipo.once.elizabeth.richard.wilson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SolicitudAreaComunController {


    @RequestMapping(value = "/solicitudes/areacomun", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        ModelAndView modelAndView = new ModelAndView("/solicitudes/areacomun/registrar");

        return modelAndView;
    }
}
