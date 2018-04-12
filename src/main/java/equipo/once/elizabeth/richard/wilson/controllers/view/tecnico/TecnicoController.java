package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import equipo.once.elizabeth.richard.wilson.controllers.view.CommonViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/tecnico")
public class TecnicoController extends CommonViewController {
  public static final String TECNICO_INDEX_VIEW = "tecnico/index";

}
