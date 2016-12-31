package equipo.once.elizabeth.richard.wilson.entities.dao;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;

import java.util.List;

public interface AreaComunRepository {
  List<AreaComun> buscarPorPalabra(String palabra);
}
