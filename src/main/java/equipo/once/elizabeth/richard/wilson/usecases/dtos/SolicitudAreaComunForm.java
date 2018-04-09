package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;

import java.util.Date;


public class SolicitudAreaComunForm {
    public AreaComun areaComun;
    public Date fechaSolicitud;
    public String comentario;
    public Inquilino inquilino;
    public boolean disponible;
    private String areaComunCodigo = "";

    public static SolicitudAreaComunForm construirForm(DisponibilidadAreaResponse response) {
        SolicitudAreaComunForm form = new SolicitudAreaComunForm();
        form.setDisponible(response.disponible);
        form.setAreaComun(response.areaComun);
        return form;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getAreaComunCodigo() {
        return areaComunCodigo;
    }

    public void setAreaComunCodigo(String areaComunCodigo) {
        this.areaComunCodigo = areaComunCodigo;
    }
}
