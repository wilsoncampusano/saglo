package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;

import java.util.List;
import java.util.Map;

public interface CatalogoService {

  Map<String, String> catalogoUbicacionAveria();
  Map<String, String> catalogoTipoAveria();
  Map<String, String> catalogoIncidenteAveria();

  Map<String, String> catalogoEstadosAveria();

  Catalogo buscarUbicacion(Long ubicacionId);

  Catalogo buscarTipoAveria(Long tipoAveriaId);

  Catalogo buscarTipoIncidente(Long tipoIncidenteId);

  List<Catalogo> buscarTipoTecnicos();

  List<Catalogo> estadosAveria();
}
