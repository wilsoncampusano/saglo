package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.repository.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.repository.SolicitudAreaComunRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class AreaComunServiceImpl implements AreaComunService{

  @Autowired
  private AreaComunRepositoryCustom areaComunRepository;

  @Autowired
  private SolicitudAreaComunRepository solicitudAreaComunRepository;

  @Override
  public void buscarDisponibilidad(AreaComun areaComun, SolicitudAreacomun solicitudAreacomun) {

  }

  @Override
  public boolean disponibleALafecha(String codigoArea, Date fechaSolicitud) {
    List<SolicitudAreacomun> solicitudAreacomuns = solicitudAreaComunRepository.buscarAreacomunReservadaALaFecha(codigoArea, fechaSolicitud);
    return Objects.nonNull(solicitudAreacomuns) && solicitudAreacomuns.isEmpty();
  }

  @Override
  public AreaComun buscarPorCodigo(String codigoArea) {
    return areaComunRepository.buscarPorCodigo(codigoArea);
  }

  @Override
  public List<AreaComun> buscarPorPalabra(String palabraBusqueda) {
    return areaComunRepository.findByNombreIgnoreCaseContaining(palabraBusqueda);
  }

  public void setAreaComunRepository(AreaComunRepositoryCustom areaComunRepository) {
    this.areaComunRepository = areaComunRepository;
  }
}
