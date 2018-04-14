package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiliarioInquilinoRepository extends CrudRepository<MobiliarioInquilino, Long>{
  @Query("select mi from MobiliarioInquilino mi where mi.inquilino.id = :inquilinoId")
  MobiliarioInquilino buscar(@Param("inquilinoId") Long inquilinoId);
}
