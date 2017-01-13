package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

import java.util.List;

/**
 * Created by wicampusano on 1/13/2017.
 */
public class BuscarSolicitudesInquilinoResponse implements InquilinoResponse{
    public List<SolicitudInquilino> solicitudes;
}
