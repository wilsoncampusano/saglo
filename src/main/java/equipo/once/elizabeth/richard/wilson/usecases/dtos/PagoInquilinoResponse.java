package equipo.once.elizabeth.richard.wilson.usecases.dtos;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoResponse;

import java.util.List;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class PagoInquilinoResponse implements InquilinoResponse {
    public List<PagoInquilino> pagos;
}
