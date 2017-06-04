package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexInquilinoController extends InquilinoController {

    @RequestMapping(value = {"/","","/index", "home"}, method = RequestMethod.GET)
    public ModelAndView inquilinoIndexGet(){
        ModelAndView modelAndView = new ModelAndView(INQUILINO_INDEX);

        return modelAndView;
    }

}
