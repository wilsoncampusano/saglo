package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;
import equipo.once.elizabeth.richard.wilson.repository.CatalogoRepository;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CatalogoServiceImpl implements CatalogoService {

  @Autowired
  CatalogoRepository catalogoRepository;

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


  @Override
  public Catalogo buscarUbicacion(Long ubicacionId) {
    return catalogoRepository.buscar("UBICACION",ubicacionId) ;
  }

  @Override
  public Catalogo buscarTipoAveria(Long tipoAveriaId) {
    return catalogoRepository.buscar("TIPO_AVERIA", tipoAveriaId);
  }

  @Override
  public Catalogo buscarTipoIncidente(Long tipoIncidenteId) {
    return catalogoRepository.buscar("TIPO_INCIDENTE", tipoIncidenteId);
  }

  @Override
  public List<Catalogo> buscarTipoTecnicos() {
    return catalogoRepository.buscar("TIPO_TECNICO");
  }
}
