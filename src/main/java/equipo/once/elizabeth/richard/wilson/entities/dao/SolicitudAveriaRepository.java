package equipo.once.elizabeth.richard.wilson.entities.dao;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudAveriaRepository extends CrudRepository<SolicitudCasoAveria, Long> {
  List<SolicitudCasoAveria> buscarSolicitudesDelInquilino(Long inqulinoID);
}
