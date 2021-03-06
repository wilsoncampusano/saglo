package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.services.SolicitudInquilinoService;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarSolicitudesInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.dtos.BuscarSolicitudesInquilinoResponse;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.InquilinoUseCase;
import equipo.once.elizabeth.richard.wilson.usecases.interfaces.UseCaseResponse;

import java.util.List;

public class BuscarSolicitudesInquilinoUseCase implements InquilinoUseCase{
    public BuscarSolicitudesInquilinoRequest request;
    private BuscarSolicitudesInquilinoResponse response;
    public SolicitudInquilinoService solicitudInquilinoService;

    @Override
    public void solicitar() {
        response = new BuscarSolicitudesInquilinoResponse();
        List<SolicitudAreacomun> solicitudesInquilino =
                solicitudInquilinoService
                .buscarSolicitudesDe(request.inquilino);

        response.solicitudes = solicitudesInquilino;
    }

    @Override
    public UseCaseResponse obtenerRespuesta() {
        return response;
    }
}
