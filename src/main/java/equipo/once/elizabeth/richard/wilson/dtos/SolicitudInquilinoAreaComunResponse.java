package equipo.once.elizabeth.richard.wilson.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

public class SolicitudInquilinoAreaComunResponse implements InquilinoResponse{
    public SolicitudAreaComunForm form;
    public SolicitudAreacomun solicitud;
}
