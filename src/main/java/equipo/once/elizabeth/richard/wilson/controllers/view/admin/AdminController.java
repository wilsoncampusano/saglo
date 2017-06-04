package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import equipo.once.elizabeth.richard.wilson.controllers.view.CommonViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController extends CommonViewController {
  public static final String ADMIN_INDEX_VIEW = "/admin/index";

}
