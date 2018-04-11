package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface InquilinoRepository extends CrudRepository<Inquilino, Long> {

  @Query("select i from Inquilino i where i.usuario.username = :username")
  Inquilino bucarPorUsuario(@Param("username") String username);
}
