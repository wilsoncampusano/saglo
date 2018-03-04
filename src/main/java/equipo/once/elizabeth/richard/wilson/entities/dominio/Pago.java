package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;


  @Column(name = "tipo_pago")
  public String tipoPago;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTipoPago() {
    return tipoPago;
  }

  public void setTipoPago(String tipoPago) {
    this.tipoPago = tipoPago;
  }
}
