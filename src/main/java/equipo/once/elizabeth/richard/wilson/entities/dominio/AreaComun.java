package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "areacomun")
public class AreaComun{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  public String nombre;
  public String codigo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AreaComun areaComun = (AreaComun) o;

    return codigo != null ? codigo.equals(areaComun.codigo) : areaComun.codigo == null;

  }

  @Override
  public int hashCode() {
    return codigo != null ? codigo.hashCode() : 0;
  }

  public static AreaComun crear(String codigo, String nombre) {
    AreaComun areaComun = new AreaComun();
    areaComun.nombre = nombre;
    areaComun.codigo = codigo;
    return areaComun;
  }
}
