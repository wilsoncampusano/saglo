package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

import java.util.List;


public class BuscarSolicitudesInquilinoResponse implements InquilinoResponse{
    public List<SolicitudInquilino> solicitudes;
}
