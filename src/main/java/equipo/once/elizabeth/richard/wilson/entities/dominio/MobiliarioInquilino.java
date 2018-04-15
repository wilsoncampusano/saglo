package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;


@Entity
@Table(name = "mobiliario_inquilino")
@Cacheable(false)
public class MobiliarioInquilino {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  @ManyToOne
  public Inquilino inquilino;

  @ManyToOne
  public Mobiliario mobiliario;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Inquilino getInquilino() {
    return inquilino;
  }

  public void setInquilino(Inquilino inquilino) {
    this.inquilino = inquilino;
  }

  public Mobiliario getMobiliario() {
    return mobiliario;
  }

  public void setMobiliario(Mobiliario mobiliario) {
    this.mobiliario = mobiliario;
  }
}
