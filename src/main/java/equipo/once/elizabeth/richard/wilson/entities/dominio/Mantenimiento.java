package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
}
