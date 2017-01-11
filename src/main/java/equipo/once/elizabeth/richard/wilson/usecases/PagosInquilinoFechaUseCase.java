package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.UseCaseResponse;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class PagosInquilinoFechaUseCase implements InquilinoUseCase{
    public PagoInquilinoRequest request;


    @Override
    public void solicitar() {
        
    }

    @Override
    public UseCaseResponse obtenerRespuesta() {
        PagoInquilinoResponse response = new PagoInquilinoResponse();
        return response;
    }
}
