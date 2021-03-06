package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.repository.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;

import java.util.Date;
import java.util.List;

public interface AreaComunService {
   void buscarDisponibilidad(AreaComun areaComun, SolicitudAreacomun solicitudAreacomun);
   boolean disponibleALafecha(String codigoArea, Date fechaSolicitud);
   AreaComun buscarPorCodigo(String codigoArea);
   List<AreaComun> buscarPorPalabra(String palabraBusqueda);

   void setAreaComunRepository(AreaComunRepositoryCustom areaComunRepository);
}
