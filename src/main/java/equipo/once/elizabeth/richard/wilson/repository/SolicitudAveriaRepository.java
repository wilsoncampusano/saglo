package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudAveriaRepository extends CrudRepository<SolicitudCasoAveria, Long> {

  @Query("select sa from SolicitudCasoAveria sa where sa.inquilino.id = :inquilinoId")
  List<SolicitudCasoAveria> buscarSolicitudesDelInquilino(@Param("inquilinoId") Long inqulinoID);

  @Query("select s from SolicitudCasoAveria s where s.estatus <> :estatus ")
  List<SolicitudCasoAveria> buscarTodasLasPendientesYEnProceso(@Param("estatus") String estatus);

  @Query(value = "select s.* from solicitud_averia s where s.tecnico_id = ?1", nativeQuery = true)
  List<SolicitudCasoAveria> buscarAsignadasA(Long tecnicoId);
}
