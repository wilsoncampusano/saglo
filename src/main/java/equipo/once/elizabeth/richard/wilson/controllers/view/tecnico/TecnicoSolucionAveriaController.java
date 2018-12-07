package equipo.once.elizabeth.richard.wilson.controllers.view.tecnico;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TecnicoSolucionAveriaController extends TecnicoController{

  @Autowired
  TecnicoService tecnicoService;

  @RequestMapping(value = {"/averias/averias","averias/averias"})
  public ModelAndView getAverias(Authentication authentication){

    ModelAndView modelAndView = new ModelAndView("tecnico/averias/gestionar");

    Tecnico tecnico = obtenerTecnico(authentication);

    List<SolicitudCasoAveria> averias = tecnicoService.buscarAverias(tecnico);

    modelAndView.addObject("averias",averias);
    return modelAndView;
  }


  @RequestMapping(value = {"/averias/gestionar","averias/gestionar"})
  public ModelAndView postGestionar(Authentication authentication){

    ModelAndView modelAndView = new ModelAndView("tecnico/averias/gestionar");

    Tecnico tecnico = obtenerTecnico(authentication);

    List<SolicitudCasoAveria> averias = tecnicoService.buscarAverias(tecnico);

    modelAndView.addObject("averias",averias);
    return modelAndView;
  }
}
