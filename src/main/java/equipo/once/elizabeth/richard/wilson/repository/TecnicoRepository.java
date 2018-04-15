package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnicoRepository extends CrudRepository<Tecnico, Long> {
  @Query("select t from Tecnico t where t.tipo = :tipoTecnico")
  List<Tecnico> buscarPorTipo(@Param("tipoTecnico") String tipoTecnico);

}
