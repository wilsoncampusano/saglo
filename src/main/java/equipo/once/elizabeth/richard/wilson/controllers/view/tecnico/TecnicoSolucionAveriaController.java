package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.Mensaje;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Estatus;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;


@Controller
public class TecnicoSolucionAveriaController extends TecnicoController{

  @Autowired
  TecnicoService tecnicoService;
  @Autowired
  CatalogoService catalogoService;

  @Autowired
  SolicitudAveriaService solicitudAveriaService;

  @RequestMapping(value = {"/averias/averias","averias/averias"})
  public ModelAndView getAverias(Authentication authentication){

    ModelAndView modelAndView = new ModelAndView("tecnico/averias/gestionar");

    Tecnico tecnico = obtenerTecnico(authentication);

    List<SolicitudCasoAveria> averias = tecnicoService.buscarAverias(tecnico);

    modelAndView.addObject("averias",averias);
    return modelAndView;
  }


  @RequestMapping(value = {"/averias/gestionar","/averias/gestionar/"})
  public ModelAndView getGestionar(@RequestParam(value = "averiaId", required = false) Long averiaId,
                                   @RequestParam(value = "exito", required = false) String exito,
                                   Authentication authentication){

    ModelAndView modelAndView = new ModelAndView("tecnico/averias/averias");

    if(Objects.nonNull(exito) && exito.equals("true")){

      Mensaje mensaje = Mensaje.EXITO;
      mensaje.setMensaje("El caso fue gestionado!");

      modelAndView.addObject(MENSAJE_KEY, mensaje);

    }
    Tecnico tecnico = obtenerTecnico(authentication);

    SolicitudAveriaDetalle sa = tecnicoService.buscarAveria(averiaId,tecnico);

    modelAndView.addObject("averia",sa);
    modelAndView.addObject("estados",catalogoService.catalogoEstadosAveria());

    return modelAndView;
  }

  @RequestMapping(value = {"/averias/gestionar/estado","/averias/gestionar/estado/"}, params = {"aprobar"})
  public String postGestionar(SolicitudAveriaDetalle solicitudAveriaDetalle,
                                   Authentication authentication,
                                    RedirectAttributes redirectAttributes){

    solicitudAveriaService.cambiarEstado(solicitudAveriaDetalle.estado, solicitudAveriaDetalle.id);
    solicitudAveriaService.comentario(solicitudAveriaDetalle.comentario, solicitudAveriaDetalle.id);

    redirectAttributes.addAttribute("averiaId", solicitudAveriaDetalle.id);
    redirectAttributes.addAttribute("exito", "true");

    return "redirect:/tecnico/averias/gestionar";  }

}
