package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="solicitud_averia")
public class SolicitudCasoAveria {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  public Date fechaSolicitud;
  public Long ubicacionId;
  public Long tipoAveriaId;
  public Long tipoIncidenteId;
  public String comentario;

  @ManyToOne
  public Inquilino inquilino;

  @ManyToOne
  public MobiliarioInquilino mobiliarioInquilino;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getFechaSolicitud() {
    return fechaSolicitud;
  }

  public void setFechaSolicitud(Date fechaSolicitud) {
    this.fechaSolicitud = fechaSolicitud;
  }

  public Inquilino getInquilino() {
    return inquilino;
  }

  public void setInquilino(Inquilino inquilino) {
    this.inquilino = inquilino;
  }

  public MobiliarioInquilino getMobiliarioInquilino() {
    return mobiliarioInquilino;
  }

  public void setMobiliarioInquilino(MobiliarioInquilino mobiliarioInquilino) {
    this.mobiliarioInquilino = mobiliarioInquilino;
  }

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
}
