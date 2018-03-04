package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "mobiliario")
public class Mobiliario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
}
