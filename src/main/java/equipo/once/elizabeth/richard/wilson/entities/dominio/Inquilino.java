package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "inquilino")
public class Inquilino extends Entidad {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public String nombres;
  public String apellidos;

  @Override
  public String getCodigo() {
    return super.getCodigo();
  }

  @Override
  public void setCodigo(String codigo) {
    super.setCodigo(codigo);
  }
}
