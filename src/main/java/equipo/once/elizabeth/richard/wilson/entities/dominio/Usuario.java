package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  public Usuario() {
  }

  public Usuario(Long id){
    this.id = id;
  }
}
