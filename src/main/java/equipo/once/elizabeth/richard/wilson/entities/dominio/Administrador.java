package equipo.once.elizabeth.richard.wilson.entities.dominio;

import equipo.once.elizabeth.richard.wilson.entities.seguridad.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "administrado")
public class Administrador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  @Column(name = "nombre")
  public String nombre;

  @OneToOne
  public Usuario usuario;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
