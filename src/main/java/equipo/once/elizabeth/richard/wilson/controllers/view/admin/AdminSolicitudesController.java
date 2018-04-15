package equipo.once.elizabeth.richard.wilson.controllers.view.admin;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.Mensaje;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Estatus;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import liquibase.structure.core.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/admin/locales/")
public class AdminSolicitudesController extends AdminController {


  private static final String ADMIN_ESTADOS_SOLICITUDES = "admin/solicitudes/solicitudes";
  private static final String ADMIN_AVERIAS_SOLICITUDES = "admin/solicitudes/averias";
  private static final String ADMIN_SOLICITUDES_GESTIONAR= "admin/locales/solicitudes/aprobar";
  private static final String ADMIN_AVERIAS_APROBAR= "admin/locales/averias/asignar";
  private static final String ADMIN_AVERIAS_ASIGNAR= "admin/locales/averias/asignar :: tecnicos";
  @Autowired
  private SolicitudAreacomunService solicitudAreacomunService;

  @Autowired
  private SolicitudAveriaService solicitudAveriaService;

  @Autowired
  CatalogoService catalogoService;

  @Autowired
  TecnicoService tecnicoService;

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



  @RequestMapping(value = {"/solicitud/aprobar","solicitud/aprobar"})
  public ModelAndView getGestionar(@RequestParam(value = "solicitudId", required = false) Long solicitudId, Authentication authentication){

    ModelAndView modelAndView = new ModelAndView(ADMIN_SOLICITUDES_GESTIONAR);

    SolicitudAreaDetalle sa = solicitudAreacomunService.buscarSolicitudPorId(solicitudId);

    modelAndView.addObject("solicitudArea",sa);
    return modelAndView;
  }

  @PostMapping(value = {"/solicitud/aprobar","solicitud/aprobar"}, params = {"aprobar"})
  public ModelAndView posGestionarAprobar(SolicitudAreaDetalle solicitudAreaDetalle,  Authentication authentication){

    ModelAndView modelAndView = new ModelAndView(ADMIN_SOLICITUDES_GESTIONAR);

    solicitudAreacomunService.cambiarEstado(Estatus.APROBADA, solicitudAreaDetalle);


    Mensaje mensaje = Mensaje.EXITO;
    mensaje.setMensaje("La solicitud ha sido aprobada");
    modelAndView.addObject(MENSAJE_KEY, mensaje);
    modelAndView.addObject("solicitudArea",solicitudAreaDetalle);
    return modelAndView;
  }

  @PostMapping(value = {"/solicitud/aprobar","solicitud/aprobar"}, params = {"rechazar"})
  public ModelAndView posGestionarRechazar(SolicitudAreaDetalle solicitudAreaDetalle, Authentication authentication){

    ModelAndView modelAndView = new ModelAndView(ADMIN_SOLICITUDES_GESTIONAR);

    solicitudAreacomunService.cambiarEstado(Estatus.RECHAZADA, solicitudAreaDetalle);

    Mensaje mensaje = Mensaje.ADVERTENCIA;
    mensaje.setMensaje("La solicitud fue Rechazada");

    modelAndView.addObject(MENSAJE_KEY, mensaje);
    modelAndView.addObject("solicitudArea",solicitudAreaDetalle);
    return modelAndView;
  }


  @RequestMapping(value = {"/averias/asignar","averias/asignar"})
  public ModelAndView getAsignar(@RequestParam("averiaId") Long averiaId,
                                 @RequestParam(value = "exito", required = false) String exito,
                                  Authentication authentication){

    ModelAndView modelAndView = new ModelAndView(ADMIN_AVERIAS_APROBAR);

    if(Objects.nonNull(exito) && exito.equals("true")){

      Mensaje mensaje = Mensaje.EXITO;
      mensaje.setMensaje("La solicitud fue asignada con exito!");

      modelAndView.addObject(MENSAJE_KEY, mensaje);

    }


    SolicitudAveriaDetalle sa = solicitudAveriaService.buscarSolicitudPorId(averiaId);
    List<Catalogo> tipoTecnicos = catalogoService.buscarTipoTecnicos();
    modelAndView.addObject("tipoTecnicos", tipoTecnicos);
    modelAndView.addObject("solicitudAveria",sa);
    return modelAndView;
  }

  @PostMapping(value = {"/averias/asignar","averias/asignar"}, params = {"asignar"})
  public String posAsignarAveria(SolicitudAveriaDetalle solicitudAveriaDetalle,
                                 Authentication authentication , RedirectAttributes redirectAttributes){

    solicitudAveriaService.asignar(solicitudAveriaDetalle);
    solicitudAveriaService.cambiarEstado(Estatus.PROCESO, solicitudAveriaDetalle.id);

    redirectAttributes.addAttribute("averiaId", solicitudAveriaDetalle.id);
    redirectAttributes.addAttribute("exito", "true");
    return "redirect:/admin/locales/averias/asignar";
  }


  @PostMapping(value = {"/solicitudes/averia/ajax/tecnicos","solicitudes/averia/ajax/tecnicos"})
  public ModelAndView postTecnicos(SolicitudAveriaDetalle solicitudAveriaDetalle, Authentication authentication){

    ModelAndView modelAndView = new ModelAndView(ADMIN_AVERIAS_ASIGNAR);
    List<Tecnico> tecnicos = tecnicoService.buscarTecnicosPorTipo(solicitudAveriaDetalle.tipoTecnico);
    modelAndView.addObject("tecnicos",tecnicos);
    modelAndView.addObject("solicitudAveria",solicitudAveriaDetalle);
    return modelAndView;
  }


}
