package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "catalogos")
@Cacheable(false)
public class Catalogo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public String codigo;
  public String nombre;
  public String descripcion;
  public Long valor;

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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Long getValor() {
    return valor;
  }

  public void setValor(Long valor) {
    this.valor = valor;
  }
}
