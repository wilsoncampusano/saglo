package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "areacomun")
public class AreaComun extends Entidad{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public String nombre;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public static AreaComun crear(String codigo, String nombre) {
    AreaComun areaComun = new AreaComun();
    areaComun.nombre = nombre;
    areaComun.codigo = codigo;
    return areaComun;
  }
}
