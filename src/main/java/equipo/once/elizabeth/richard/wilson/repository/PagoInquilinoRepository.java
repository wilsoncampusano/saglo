package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoInquilinoRepository extends CrudRepository<PagoInquilino, Long> {

  @Query("select p from PagoInquilino p where p.inquilino.id = :inquilinoId")
  public List<PagoInquilino> byInquilinoId(@Param("inquilinoId") Long inquilinoId);
}
