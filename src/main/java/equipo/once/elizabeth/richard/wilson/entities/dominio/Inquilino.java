package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "inquilino")
public class Inquilino {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public String codigo;
  public String nombres;
  public String apellidos;

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Inquilino inquilino = (Inquilino) o;

    return codigo != null ? codigo.equals(inquilino.codigo) : inquilino.codigo == null;

  }

  @Override
  public int hashCode() {
    return codigo != null ? codigo.hashCode() : 0;
  }
}
