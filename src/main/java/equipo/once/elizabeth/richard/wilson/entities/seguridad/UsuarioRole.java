package equipo.once.elizabeth.richard.wilson.entities.seguridad;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class UsuarioRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String role;
    @ManyToMany(mappedBy = "roles")
    public Set<Usuario> usuarios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
