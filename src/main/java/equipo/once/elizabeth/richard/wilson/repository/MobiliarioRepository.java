package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Mobiliario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiliarioRepository extends CrudRepository<Mobiliario, Long>{
}
