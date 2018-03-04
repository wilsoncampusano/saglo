package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "solicitud_mantenimiento")
public class SolicitudMantenimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
}
