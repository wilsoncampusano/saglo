package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.Mensaje;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudCasoAveriaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/inquilino/solicitudes")
public class SolicitudCasoAveriaController extends InquilinoController  {

    public static final String SOLICITUDES_AVERIA_REGISTRAR = "inquilino/solicitudes/casoaveria/registrar";
    public static final String FORMULARIO_KEY = "form";

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private SolicitudAveriaService solicitudAveriaService;

    @RequestMapping(value = "/casoaveria", method = RequestMethod.GET)
    public ModelAndView solicitudesCasoAveriaGet(){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AVERIA_REGISTRAR);

        cargarCatalogos(modelAndView);

        SolicitudCasoAveriaForm formulario = new SolicitudCasoAveriaForm();

        modelAndView.addObject(FORMULARIO_KEY, formulario);

        return modelAndView;
    }

    private void cargarCatalogos(ModelAndView modelAndView) {
        modelAndView.addObject("catalogoIncidente", catalogoService.catalogoIncidenteAveria());
        modelAndView.addObject("catalogoTipoAveria", catalogoService.catalogoTipoAveria());
        modelAndView.addObject("catalogoUbiciacion", catalogoService.catalogoUbicacionAveria());
    }

    @RequestMapping(value = "casoaveria", method = RequestMethod.POST)
    public ModelAndView solicitudesCasoAveriaPostRegistrar(SolicitudCasoAveriaForm form ,
                                                           RedirectAttributes redirectAttrs,
                                                           HttpSession httpSession,
                                                           Authentication auth){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AVERIA_REGISTRAR);
        cargarCatalogos(modelAndView);
        Mensaje mensaje;
        if(! form.isValido()){
            mensaje = Mensaje.ADVERTENCIA;
            mensaje.setMensaje("Favor completar los datos requeridos!");
        }else{
            form.inquilino = obtenerInquilino(auth);
            solicitudAveriaService.guardar(form);
            mensaje = Mensaje.EXITO;
            mensaje.setMensaje("Se ha guardado su solicitud!");
        }

        modelAndView.addObject(MENSAJE_KEY, mensaje);
        modelAndView.addObject(FORMULARIO_KEY, form);
        return modelAndView;
    }

}
