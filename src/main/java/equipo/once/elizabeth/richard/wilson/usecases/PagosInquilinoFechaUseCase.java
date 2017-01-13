package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.PagoInquilinoResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.UseCaseResponse;

import java.util.List;
import java.util.stream.Collectors;


public class PagosInquilinoFechaUseCase implements InquilinoUseCase{
    public PagoInquilinoRequest request;
    private PagoInquilinoResponse response;
    public PagoInquilinoService pagoInquilinoService;


    @Override
    public void solicitar() {

        List<PagoInquilino> pagoInquilinos = pagoInquilinoService
                .pagosPorEntidadDesdeFecha(request.entidad, request.fechaInicio);

        response = new PagoInquilinoResponse();

        response.pagos = pagoInquilinos.stream().filter(pagoInquilino ->
        {
            return pagoInquilino.estado.equals(request.estado);
        }).collect(Collectors.toList());
    }

    @Override
    public UseCaseResponse obtenerRespuesta() {
        return response;
    }
}
