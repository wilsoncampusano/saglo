package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;

import java.util.List;
import java.util.Map;

public interface SolicitudAveriaCatalogoService {

  Map<String, String> catalogoUbicacionAveria();
  Map<String, String> catalogoTipoAveria();
  Map<String, String> catalogoIncidenteAveria();

  Catalogo buscarUbicacion(Long ubicacionId);

  Catalogo buscarTipoAveria(Long tipoAveriaId);

  Catalogo buscarTipoIncidente(Long tipoIncidenteId);
}
