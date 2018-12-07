package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="solicitud_averia")
@Cacheable(false)
public class SolicitudCasoAveria {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  public Date fechaSolicitud;
  public Long ubicacionId;
  public Long tipoAveriaId;
  public Long tipoIncidenteId;
  public String comentario;
  public String estatus;

  @ManyToOne
  public Inquilino inquilino;

  @ManyToOne
  public Tecnico tecnico;

  @ManyToOne
  public MobiliarioInquilino mobiliarioInquilino;
  public String comentarioSolucion;

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

  public String getEstatus() {
    return estatus;
  }

  public void setEstatus(String estatus) {
    this.estatus = estatus;
  }

  public Tecnico getTecnico() {
    return tecnico;
  }

  public void setTecnico(Tecnico tecnico) {
    this.tecnico = tecnico;
  }
}
