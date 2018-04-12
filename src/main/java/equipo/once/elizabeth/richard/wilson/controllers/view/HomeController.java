package equipo.once.elizabeth.richard.wilson.controllers.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  @RequestMapping(value = "/acerca", method = RequestMethod.GET)
  public String registration(Model model) {

    return "acerca";
  }

  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String noautorizado(Model model) {

    return "403";
  }
}
