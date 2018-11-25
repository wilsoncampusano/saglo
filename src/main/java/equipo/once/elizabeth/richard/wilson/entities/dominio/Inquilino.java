package equipo.once.elizabeth.richard.wilson.entities.dominio;

import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inquilino")
@Cacheable(false)
public class Inquilino {
  public Inquilino(Usuario usuario) {
    this.usuario = usuario;
  }

  public Inquilino(Long id){
    this.id = id;
  }

  public Inquilino() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public String codigo;
  public String nombre;
  public Date fechaIngreso;
  public Long activo;
  @OneToOne
  public Usuario usuario;

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

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

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
