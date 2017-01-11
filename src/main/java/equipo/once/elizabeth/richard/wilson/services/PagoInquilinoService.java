package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;

import java.util.List;

/**
 * Created by wicampusano on 1/11/2017.
 */
public interface PagoInquilinoService {
    List<PagoInquilino> pagosPorEstadoDesdeFecha(String estado, String fecha);

}
