package equipo.once.elizabeth.richard.wilson.seguridad;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  public String username;
  public String password;

  @ManyToMany
  @JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  public Set<UsuarioRole> roles;

  @Transient
  private String passwordConfirm;

  public Usuario() {
  }

  public Usuario(Long id){
    this.id = id;
  }

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

  public Set<UsuarioRole> getRoles() {
    return roles;
  }

  public void setRoles(Set<UsuarioRole> roles) {
    this.roles = roles;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }
}
