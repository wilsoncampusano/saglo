package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/inquilino/solicitudes/")
public class SolicitudAreaComunController extends InquilinoController  {


    public static final String SOLICITUDES_AREACOMUN_REGISTRAR = "/inquilino/solicitudes/areacomun/registrar";

    @RequestMapping(value = "areacomun", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"registrar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostRegistrar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"cancelar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostCancelar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }



    @RequestMapping(value = "areacomun",params = {"verificarDisponibilidad"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostVerificar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                         HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }
}
