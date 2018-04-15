package equipo.once.elizabeth.richard.wilson.entities.dominio;

import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "tecnico")
@Cacheable(false)
public class Tecnico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String tipo;
  public String nombre;

  @OneToOne()
  public Usuario usuario;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
