package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.controllers.view.CommonViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wicampusano on 1/5/2017.
 */
@Controller
@RequestMapping("/inquilino")
public class IndexInquilinoController extends InquilinoController {

    public static final String SOLICITUDES_AREACOMUN_REGISTRAR = "/inquilino/index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView solicitudesAreaComunGet(){
        ModelAndView modelAndView = new ModelAndView(SOLICITUDES_AREACOMUN_REGISTRAR);

        return modelAndView;
    }

}
