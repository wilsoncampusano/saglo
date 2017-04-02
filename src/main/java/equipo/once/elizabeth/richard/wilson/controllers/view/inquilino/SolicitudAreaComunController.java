package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaResponse;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/inquilino/solicitudes/")
public class SolicitudAreaComunController extends InquilinoController  {

    @Autowired
    private DisponibilidadAreaComunUseCase disponibilidadAreaComunUseCase;
    ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

    public static final String SOLICITUDES_AREACOMUN_REGISTRAR = "/inquilino/solicitudes/areacomun/registrar";

    @RequestMapping(value = "areacomun", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        modelAndView.clear();
        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"registrar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostRegistrar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        modelAndView.clear();

        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"cancelar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostCancelar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        modelAndView.clear();

        return modelAndView;
    }



    @RequestMapping(value = "areacomun",params = {"verificarDisponibilidad"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostVerificar(SolicitudAreaComunForm form ,
                                                          RedirectAttributes redirectAttrs,
                                                         HttpSession httpSession){
        modelAndView.clear();
        DisponibilidadAreaRequest request = DisponibilidadAreaRequest.construirRequest(form);
        disponibilidadAreaComunUseCase.request = request;

        disponibilidadAreaComunUseCase.solicitar();

        DisponibilidadAreaResponse response =
            (DisponibilidadAreaResponse) disponibilidadAreaComunUseCase.obtenerRespuesta();


        form = SolicitudAreaComunForm.construirForm(response);

        modelAndView.addObject("solicitudAreaComunForm", form);

        return modelAndView;
    }
}
