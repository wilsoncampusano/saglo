package equipo.once.elizabeth.richard.wilson.entities.dao;

import equipo.once.elizabeth.richard.wilson.entities.seguridad.UsuarioRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created on 4/11/2018.
 */
@Repository
public interface RoleRepository extends CrudRepository<UsuarioRole, Long> {
}
