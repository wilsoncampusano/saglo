package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="solicitud_areacomun")
public class SolicitudAreacomun extends Entidad {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String fechaSolicitud;

  @ManyToOne
  public Inquilino inquilino;
  @ManyToOne
  public AreaComun areaComun;
}
