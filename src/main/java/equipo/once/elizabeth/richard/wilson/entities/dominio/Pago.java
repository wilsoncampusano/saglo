package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
}
