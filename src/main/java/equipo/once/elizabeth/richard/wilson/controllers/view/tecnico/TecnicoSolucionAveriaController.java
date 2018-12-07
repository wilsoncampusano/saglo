package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TecnicoSolucionAveriaController extends TecnicoController{

  @Autowired
  TecnicoService tecnicoService;
  @Autowired
  CatalogoService catalogoService;

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
                                   Authentication authentication){

    ModelAndView modelAndView = new ModelAndView("tecnico/averias/averias");
    Tecnico tecnico = obtenerTecnico(authentication);

    SolicitudAveriaDetalle sa = tecnicoService.buscarAveria(averiaId,tecnico);

    modelAndView.addObject("averia",sa);
    modelAndView.addObject("estados",catalogoService.catalogoEstadosAveria());

    return modelAndView;
  }

  @RequestMapping(value = {"/averias/gestionar","/averias/gestionar/"}, params = {"aprobar"})
  public ModelAndView postGestionar(SolicitudAveriaDetalle solicitudAveriaDetalle,
                                   Authentication authentication){


    return null;
  }

}
