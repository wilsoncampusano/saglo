package equipo.once.elizabeth.richard.wilson.entities.dao;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created on 4/9/2018.
 */
@Repository
public interface SolicitudAreaComunRepository extends CrudRepository<SolicitudAreacomun, Long> {
    @Query("select sac from SolicitudAreacomun sac where sac.areaComun.codigo = :codigo and sac.fechaSolicitud = :fecha")
    List<SolicitudAreacomun> buscarAreacomunReservadaALaFecha(@Param("codigo") String codigo, @Param("fecha") Date fecha);

    @Query("select sac from SolicitudAreacomun sac where sac.inquilino.id = :inquilinoId")
    List<SolicitudAreacomun> buscarSolicitudesDelInquilino(@Param("inquilinoId") Long inquilinoId);
}
