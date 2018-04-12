package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.controllers.view.CommonViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/inquilino")
public class InquilinoController extends CommonViewController {
  public static final String INQUILINO_INDEX = "inquilino/index";
}
