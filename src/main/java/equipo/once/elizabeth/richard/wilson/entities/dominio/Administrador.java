package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "administrado")
public class Administrador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

}
