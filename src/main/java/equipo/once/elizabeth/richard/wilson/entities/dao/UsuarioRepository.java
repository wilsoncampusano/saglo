package equipo.once.elizabeth.richard.wilson.entities.dao;

import equipo.once.elizabeth.richard.wilson.entities.seguridad.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 4/11/2018.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
