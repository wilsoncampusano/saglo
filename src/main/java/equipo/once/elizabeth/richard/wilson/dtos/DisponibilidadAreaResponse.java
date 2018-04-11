package equipo.once.elizabeth.richard.wilson.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunResponse;

public class DisponibilidadAreaResponse implements AreaComunResponse{
  public boolean disponible;
  public AreaComun areaComun;
}
