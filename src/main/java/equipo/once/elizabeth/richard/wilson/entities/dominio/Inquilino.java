package equipo.once.elizabeth.richard.wilson.entities.dominio;


public class Inquilino {
  public String codigo;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Inquilino inquilino = (Inquilino) o;

    return codigo.equals(inquilino.codigo);

  }

  @Override
  public int hashCode() {
    return codigo.hashCode();
  }
}
