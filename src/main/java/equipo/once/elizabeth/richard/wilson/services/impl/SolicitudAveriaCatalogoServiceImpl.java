package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaCatalogoService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SolicitudAveriaCatalogoServiceImpl implements SolicitudAveriaCatalogoService {

  @Override
  public Map<String, String> catalogoUbicacionAveria() {
    HashMap<String, String> ubicaciones = new HashMap<>();
    ubicaciones.put("1", "Interna");
    ubicaciones.put("2", "Externa");
    return ubicaciones;
  }

  @Override
  public Map<String, String> catalogoTipoAveria() {
    HashMap<String, String> tipoAveria = new HashMap<>();
    tipoAveria.put("1", "Electricidad");
    tipoAveria.put("2", "Agua");
    tipoAveria.put("3", "Equipo");
    return tipoAveria;
  }

  @Override
  public Map<String, String> catalogoIncidenteAveria() {
    HashMap<String, String> incidentes = new HashMap<>();
    incidentes.put("1","Tuberia Rota");
    incidentes.put("2","No hay Agua");
    incidentes.put("3","Etc");
    return incidentes;
  }
}
