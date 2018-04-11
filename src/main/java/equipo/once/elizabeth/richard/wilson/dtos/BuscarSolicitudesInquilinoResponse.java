package equipo.once.elizabeth.richard.wilson.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

import java.util.List;


public class BuscarSolicitudesInquilinoResponse implements InquilinoResponse{
    public List<SolicitudAreacomun> solicitudes;
}
