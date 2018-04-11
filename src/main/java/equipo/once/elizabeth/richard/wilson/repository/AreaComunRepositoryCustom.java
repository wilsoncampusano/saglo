package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AreaComunRepositoryCustom extends CrudRepository<AreaComun, Long> {
  List<AreaComun> findByNombreIgnoreCaseContaining(String palabra);

  @Query("select a from AreaComun a where a.codigo = :codigo")
  AreaComun buscarPorCodigo(@Param("codigo") String codigoArea);
}
