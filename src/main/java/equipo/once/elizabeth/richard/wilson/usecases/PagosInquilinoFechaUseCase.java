package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.UseCaseResponse;

import java.util.List;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class PagosInquilinoFechaUseCase implements InquilinoUseCase{
    public PagoInquilinoRequest request;
    private PagoInquilinoResponse response;
    public PagoInquilinoService pagoInquilinoService;


    @Override
    public void solicitar() {

        List<PagoInquilino> pagoInquilinos = pagoInquilinoService
                .pagosPorEstadoDesdeFecha(request.estado, request.fechaInicio);
        response = new PagoInquilinoResponse();

        response.pagos = pagoInquilinos;
    }

    @Override
    public UseCaseResponse obtenerRespuesta() {
        return response;
    }
}
