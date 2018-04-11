package equipo.once.elizabeth.richard.wilson.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.AreaComunResponse;

import java.util.List;

public class BuscarAreaComunResponse implements AreaComunResponse{
  public List<AreaComun> areasComunes;
}
