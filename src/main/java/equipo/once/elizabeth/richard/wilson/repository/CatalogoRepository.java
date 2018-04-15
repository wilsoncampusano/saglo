package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Catalogo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends CrudRepository<Catalogo,Long>{

  @Query("select c from Catalogo c where c.codigo = :codigo and c.valor = :valor")
  Catalogo buscar(@Param("codigo") String codigo, @Param("valor") Long valor);

  @Query("select c from Catalogo c where c.codigo = :codigo")
  List<Catalogo> buscar(@Param("codigo") String codigo);
}
