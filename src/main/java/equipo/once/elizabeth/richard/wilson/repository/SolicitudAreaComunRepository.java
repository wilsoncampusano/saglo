package equipo.once.elizabeth.richard.wilson.repository;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
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


    @Query("select s from SolicitudAreacomun s where s.estatus <> :estatus ")
    List<SolicitudAreacomun> buscarTodasLasPendientesYEnProceso(@Param("estatus") String estatus);
}
