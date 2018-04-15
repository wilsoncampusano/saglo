package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexInquilinoController extends InquilinoController {

    @RequestMapping(value = {"/","","/index", "home"}, method = RequestMethod.GET)
    public ModelAndView inquilinoIndexGet(Authentication auth ){
        ModelAndView modelAndView = new ModelAndView(INQUILINO_INDEX);
        Inquilino inquilino = obtenerInquilino(auth);
        modelAndView.addObject("inquilino", inquilino);
        return modelAndView;
    }

}
