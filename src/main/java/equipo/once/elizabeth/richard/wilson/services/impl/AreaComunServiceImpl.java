package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaComunServiceImpl implements AreaComunService{

  @Autowired
  private AreaComunRepositoryCustom areaComunRepository;

  @Override
  public void buscarDisponibilidad(AreaComun areaComun, SolicitudAreacomun solicitudAreacomun) {

  }

  @Override
  public boolean disponibleALafecha(String codigoArea, String fechaSolicitud) {
    return false;
  }

  @Override
  public AreaComun buscarPorCodigo(String codigoArea) {
    return null;
  }

  @Override
  public List<AreaComun> buscarPorPalabra(String palabraBusqueda) {
    return areaComunRepository.findByNombreIgnoreCaseContaining(palabraBusqueda);
  }

  public void setAreaComunRepository(AreaComunRepositoryCustom areaComunRepository) {
    this.areaComunRepository = areaComunRepository;
  }
}
