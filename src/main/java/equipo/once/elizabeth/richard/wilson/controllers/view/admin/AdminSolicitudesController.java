package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/locales/")
public class AdminSolicitudesController extends AdminController {


  private static final String ADMIN_ESTADOS_SOLICITUDES = "admin/solicitudes/solicitudes";
  private static final String ADMIN_AVERIAS_SOLICITUDES = "admin/solicitudes/averias";
  @Autowired
  private SolicitudAreacomunService solicitudAreacomunService;

  @Autowired
  private SolicitudAveriaService solicitudAveriaService;

  @RequestMapping(value = {"/averias","averias"})
  public ModelAndView solicitudesAveria(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(ADMIN_AVERIAS_SOLICITUDES);

    List<SolicitudAveriaDetalle> solicitudes = new ArrayList<>();


    List<SolicitudAveriaDetalle> sr = solicitudAveriaService.buscarTodasLasSolicitudesAveriasPendiente();
    solicitudes.addAll(sr);

    modelAndView.addObject("averias",solicitudes );
    return modelAndView;
  }



  @RequestMapping(value = {"/solicitudes/","solicitudes"})
  public ModelAndView solicitudesArea(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(ADMIN_ESTADOS_SOLICITUDES);

    List<SolicitudAreaDetalle> solicitudes = new ArrayList<>();


    List<SolicitudAreaDetalle> sa = solicitudAreacomunService.buscarTodasLasSolicitudesAreaPendientes();
    solicitudes.addAll(sa);

    modelAndView.addObject("solicitudesArea",solicitudes );
    return modelAndView;
  }
}
