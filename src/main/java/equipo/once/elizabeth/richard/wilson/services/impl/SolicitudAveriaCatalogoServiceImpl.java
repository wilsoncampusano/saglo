package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaCatalogoService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SolicitudAveriaCatalogoServiceImpl implements SolicitudAveriaCatalogoService {

  @Override
  public Map<String, String> catalogoUbicacionAveria() {
    HashMap<String, String> ubicaciones = new HashMap<>();
    ubicaciones.put("int", "Interna");
    ubicaciones.put("ext", "Externa");
    return ubicaciones;
  }

  @Override
  public Map<String, String> catalogoTipoAveria() {
    HashMap<String, String> tipoAveria = new HashMap<>();
    tipoAveria.put("elect", "Electricidad");
    tipoAveria.put("agu", "Agua");
    tipoAveria.put("equi", "Equipo");
    return tipoAveria;
  }

  @Override
  public Map<String, String> catalogoIncidenteAveria() {
    HashMap<String, String> incidentes = new HashMap<>();
    incidentes.put("tub","Tuberia Rota");
    incidentes.put("noag","No hay Agua");
    incidentes.put("etc","Etc");
    return incidentes;
  }
}
