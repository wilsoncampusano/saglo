package equipo.once.elizabeth.richard.wilson.controllers.view;

import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/inquilino/solicitudes")
public class SolicitudCasoAveriaController {

    public static final String SOLICITUDES_AREACOMUN_REGISTRAR = "/inquilino/solicitudes/casoaveria/registrar";

    @RequestMapping(value = "/casoaveria", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "casoaveria",params = {"registrar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostRegistrar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                          HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "casoaveria",params = {"cancelar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostCancelar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                         HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }
}
