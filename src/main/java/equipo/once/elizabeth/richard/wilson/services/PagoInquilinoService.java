package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Entidad;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;

import java.util.List;


public interface PagoInquilinoService {
    List<PagoInquilino> pagosPorEntidadDesdeFecha(Entidad entidad, String fecha);

}
