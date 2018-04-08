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
  public String codigo;

  @ManyToOne
  public Inquilino inquilino;
  @ManyToOne
  public AreaComun areaComun;


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

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
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
}
