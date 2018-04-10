package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaCatalogoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudCasoAveriaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/inquilino/solicitudes")
public class SolicitudCasoAveriaController extends InquilinoController  {

    public static final String SOLICITUDES_AREACOMUN_REGISTRAR = "/inquilino/solicitudes/casoaveria/registrar";
    public static final String FORMULARIO_KEY = "form";

    @Autowired
    private SolicitudAveriaCatalogoService solicitudAveriaCatalogoService;

    @RequestMapping(value = "/casoaveria", method = RequestMethod.GET)
    public ModelAndView solicitudesCasoAveriaGet(){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        modelAndView.addObject("catalogoIncidente", solicitudAveriaCatalogoService.catalogoIncidenteAveria());
        modelAndView.addObject("catalogoTipoAveria", solicitudAveriaCatalogoService.catalogoTipoAveria());
        modelAndView.addObject("catalogoUbiciacion", solicitudAveriaCatalogoService.catalogoUbicacionAveria());

        SolicitudCasoAveriaForm formulario = new SolicitudCasoAveriaForm();

        modelAndView.addObject(FORMULARIO_KEY, formulario);

        return modelAndView;
    }

    @RequestMapping(value = "casoaveria",params = {"registrar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesCasoAveriaPostRegistrar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                          HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "casoaveria",params = {"cancelar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesCasoAveriaPostCancelar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                         HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }
}
