package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaComunForm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 4/9/2018.
 */
@Service
public interface SolicitudAreacomunService {


    void guardar(SolicitudAreaComunForm form );
    boolean isAreaComunDisponible(SolicitudAreaComunForm form );

    List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino);

    List<SolicitudAreaDetalle> buscarTodasLasSolicitudesAreaPendientes();

    SolicitudAreaDetalle buscarSolicitudPorId(Long solicitudId);
}
