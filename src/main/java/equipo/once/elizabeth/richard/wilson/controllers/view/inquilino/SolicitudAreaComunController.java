package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.usecases.DisponibilidadAreaComunUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.DisponibilidadAreaResponse;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
    private ModelAndView modelAndView ;
    private static final String SOLICITUD_AREACOMUN_FORM = "form";
    private static final String SOLICITUDES_AREACOMUN_REGISTRAR = "inquilino/solicitudes/areacomun/registrar";

    @RequestMapping(value = "areacomun", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);
        SolicitudAreaComunForm form = new SolicitudAreaComunForm();
        modelAndView.addObject(SOLICITUD_AREACOMUN_FORM, form);
        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"registrar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostRegistrar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

    @RequestMapping(value = "areacomun",params = {"cancelar"}, method = RequestMethod.POST)
    public ModelAndView solicitudesAreaComunPostCancelar(SolicitudAreaComunForm form , RedirectAttributes redirectAttrs,
                                                 HttpSession httpSession){
        modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);
        return modelAndView;
    }



    @RequestMapping(value = "ajax/verificar", method = RequestMethod.POST)
    public String solicitudesAreaComunPostVerificar(Model model, @ModelAttribute("form") SolicitudAreaComunForm form){
        DisponibilidadAreaRequest request = DisponibilidadAreaRequest.construirRequest(form);
        disponibilidadAreaComunUseCase.request = request;

        disponibilidadAreaComunUseCase.solicitar();

        DisponibilidadAreaResponse response =
            (DisponibilidadAreaResponse) disponibilidadAreaComunUseCase.obtenerRespuesta();


        SolicitudAreaComunForm formResponse = SolicitudAreaComunForm.construirForm(response);
        form.setDisponible(formResponse.disponible);
        model.addAttribute(SOLICITUD_AREACOMUN_FORM,form);
        model.containsAttribute("form");

        return SOLICITUDES_AREACOMUN_REGISTRAR + ":: solicitudAreaFragment";
    }
}
