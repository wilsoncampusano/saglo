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

  @ManyToOne
  public Inquilino inquilino;

  @OneToMany
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
}
