package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import org.springframework.data.repository.CrudRepository;

public interface InquilinoRepositoryCustom extends CrudRepository<Inquilino, Long> {

  Inquilino findByCodigo(String codigo);
}
