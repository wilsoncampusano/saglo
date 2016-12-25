package equipo.once.elizabeth.richard.wilson.usecases.interfaces;

import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarAreaComunResponse;

public interface AreaComunUseCase extends UseCase{
  void solicitar();
  AreaComunResponse obtenerRespuesta();
}
