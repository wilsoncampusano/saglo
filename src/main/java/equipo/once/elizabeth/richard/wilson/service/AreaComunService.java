package equipo.once.elizabeth.richard.wilson.service;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;

public interface AreaComunService {
   void buscarDisponibilidad(AreaComun areaComun, SolicitudInquilino solicitudInquilino);
   boolean disponibleALafecha(String codigoArea, String fechaSolicitud);
   AreaComun buscarPorCodigo(String codigoArea);
}
