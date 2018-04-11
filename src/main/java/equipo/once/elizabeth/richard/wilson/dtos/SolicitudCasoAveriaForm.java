package equipo.once.elizabeth.richard.wilson.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;

import java.util.Objects;

/**
 * Created on 4/10/2018.
 */
public class SolicitudCasoAveriaForm {
    public Long ubicacionId;
    public Long tipoAveriaId;
    public Long tipoIncidenteId;
    public String comentario;
    public Inquilino inquilino;

    public Long getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(Long ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public Long getTipoAveriaId() {
        return tipoAveriaId;
    }

    public void setTipoAveriaId(Long tipoAveriaId) {
        this.tipoAveriaId = tipoAveriaId;
    }

    public Long getTipoIncidenteId() {
        return tipoIncidenteId;
    }

    public void setTipoIncidenteId(Long tipoIncidenteId) {
        this.tipoIncidenteId = tipoIncidenteId;
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

    public boolean isValido() {
        Long zero = 0L;
        return (Objects.nonNull(ubicacionId) && !zero.equals(ubicacionId))
                && (Objects.nonNull(tipoAveriaId) && !zero.equals(tipoAveriaId))
                && (Objects.nonNull(tipoIncidenteId) && !zero.equals(tipoIncidenteId));
    }
}
