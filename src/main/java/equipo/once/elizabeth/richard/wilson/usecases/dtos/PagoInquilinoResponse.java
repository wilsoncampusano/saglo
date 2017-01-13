package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

import java.util.List;


public class PagoInquilinoResponse implements InquilinoResponse {
    public List<PagoInquilino> pagos;
}
