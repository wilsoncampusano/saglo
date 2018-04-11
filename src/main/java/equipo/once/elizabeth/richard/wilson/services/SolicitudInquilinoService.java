package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaComunForm;

import java.util.List;

public interface SolicitudInquilinoService {
    List<SolicitudAreacomun> buscarSolicitudesDe(Inquilino inquilino);
    SolicitudAreacomun guardar(SolicitudAreaComunForm form);
}
