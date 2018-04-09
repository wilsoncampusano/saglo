package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.stereotype.Service;

/**
 * Created on 4/9/2018.
 */
@Service
public interface SolicitudAreacomunService {


    void guardar(SolicitudAreaComunForm form );
    boolean isAreaComunDisponible(SolicitudAreaComunForm form );
}
