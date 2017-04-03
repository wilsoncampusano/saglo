package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;

import java.util.List;


public interface PagoInquilinoService {
    List<PagoInquilino> pagosPorInquilinoDesdeFecha(Inquilino entidad, String fecha);

}
