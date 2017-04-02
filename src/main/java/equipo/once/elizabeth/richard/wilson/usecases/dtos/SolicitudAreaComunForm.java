package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;


public class SolicitudAreaComunForm {
    public AreaComun areaComun;
    public String fechaSolicitud;
    public String comentario;
    public Inquilino inquilino;
    public boolean disponible;

    public static SolicitudAreaComunForm construirForm(DisponibilidadAreaResponse response) {

        return null;
    }
}
