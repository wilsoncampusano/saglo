package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;

import java.util.List;

public interface SolicitudInquilinoService {
    List<SolicitudInquilino> buscarSolicitudesDe(Inquilino inquilino);
    SolicitudInquilino guardar(SolicitudAreaComunForm form);
}
