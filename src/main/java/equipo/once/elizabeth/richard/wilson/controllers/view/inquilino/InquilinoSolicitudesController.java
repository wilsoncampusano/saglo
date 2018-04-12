package equipo.once.elizabeth.richard.wilson.controllers.view.inquilino;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.dtos.ListaSolicitudInquilinoDetalleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/inquilino/estados/")
public class InquilinoSolicitudesController extends InquilinoController{

  private static final String INQUILINO_ESTADOS_SOLICITUDES = "inquilino/estados/solicitudes";

  @Autowired
  private SolicitudAreacomunService solicitudAreacomunService;

  @Autowired
  private SolicitudAveriaService solicitudAveriaService;

  @RequestMapping(value = {"/solicitudes/","solicitudes"})
  public ModelAndView inquilinoSolicitudesGet(Authentication authentication){


    ModelAndView modelAndView = new ModelAndView(INQUILINO_ESTADOS_SOLICITUDES);

    List<ListaSolicitudInquilinoDetalleForm> solicitudes = new ArrayList<>();

    Inquilino inquilino = obtenerInquilino(authentication);

    List<ListaSolicitudInquilinoDetalleForm> sa = solicitudAreacomunService.buscarSolicitudesDelInquilino(inquilino);
    List<ListaSolicitudInquilinoDetalleForm> sr = solicitudAveriaService.buscarSolicitudesDelInquilino(inquilino);
    solicitudes.addAll(sa);
    solicitudes.addAll(sr);

    modelAndView.addObject("solicitudesForm",solicitudes );
    return modelAndView;
  }
}
