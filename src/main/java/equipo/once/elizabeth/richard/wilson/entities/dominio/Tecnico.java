package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "tecnico")
public class Tecnico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
}
