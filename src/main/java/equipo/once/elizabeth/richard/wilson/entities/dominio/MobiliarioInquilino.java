package equipo.once.elizabeth.richard.wilson.entities.dominio;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;

import javax.persistence.*;


@Entity
@Table(name = "mobiliario_inquilino")
public class MobiliarioInquilino {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public Inquilino inquilino;
}
