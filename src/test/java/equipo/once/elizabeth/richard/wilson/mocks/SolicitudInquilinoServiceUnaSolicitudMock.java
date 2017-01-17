package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.services.SolicitudInquilinoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudInquilinoServiceUnaSolicitudMock implements SolicitudInquilinoService{
    static List<SolicitudInquilino> solicitudesInquilino = new ArrayList<SolicitudInquilino>();

    static {
        SolicitudInquilino solicitudInquilino = new SolicitudInquilino();
        Inquilino inquilino = new InquilinoMock();
        solicitudInquilino.inquilino = inquilino;
        solicitudesInquilino.add(solicitudInquilino);
    }

    @Override
    public List<SolicitudInquilino> buscarSolicitudesDe(Inquilino inquilino) {
        return solicitudesInquilino
                .stream()
                .filter(s -> s.inquilino.equals(inquilino))
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudInquilino guardar(SolicitudAreaComunForm form) {
        SolicitudInquilino solicitudInquilino = new SolicitudInquilino();
        solicitudInquilino.inquilino = form.inquilino;
        solicitudInquilino.areaComun = form.areaComun;
        solicitudInquilino.fechaSolicitud = form.fechaSolicitud;
        solicitudesInquilino.add(solicitudInquilino);

        return solicitudInquilino;
    }
}
