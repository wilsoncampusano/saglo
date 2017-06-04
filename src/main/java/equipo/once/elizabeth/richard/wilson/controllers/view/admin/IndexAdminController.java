package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexAdminController extends AdminController {

  @RequestMapping(value = {"/","","/index", "home"}, method = RequestMethod.GET)
  public ModelAndView adminIndexGet(){
    ModelAndView modelAndView = new ModelAndView(ADMIN_INDEX_VIEW);

    return modelAndView;
  }
}
