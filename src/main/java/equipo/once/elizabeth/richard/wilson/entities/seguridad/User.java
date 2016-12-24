package equipo.once.elizabeth.richard.wilson.entities.seguridad;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;


}
