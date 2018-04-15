package equipo.once.elizabeth.richard.wilson.entities.dominio;

import javax.persistence.*;

@Entity
@Table(name = "tecnico")
@Cacheable(false)
public class Tecnico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String username;
  public String password;
  public String tipo;
  public Integer activo;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getActivo() {
    return activo;
  }

  public void setActivo(Integer activo) {
    this.activo = activo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
