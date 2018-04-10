package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="solicitud_areacomun")
public class SolicitudAreacomun {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  public Date fechaSolicitud;

  @ManyToOne
  public Inquilino inquilino;
  @ManyToOne
  public AreaComun areaComun;

  public String estatus;
  public String comentario;


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

  public AreaComun getAreaComun() {
    return areaComun;
  }

  public void setAreaComun(AreaComun areaComun) {
    this.areaComun = areaComun;
  }

  public String getEstatus() {
    return estatus;
  }

  public void setEstatus(String estatus) {
    this.estatus = estatus;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
