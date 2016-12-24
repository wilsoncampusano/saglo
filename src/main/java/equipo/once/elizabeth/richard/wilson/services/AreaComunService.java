package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;

import java.util.List;

public interface AreaComunService {
   void buscarDisponibilidad(AreaComun areaComun, SolicitudInquilino solicitudInquilino);
   boolean disponibleALafecha(String codigoArea, String fechaSolicitud);
   AreaComun buscarPorCodigo(String codigoArea);
   List<AreaComun> buscarPorPalabra(String palabraBusqueda);
}
