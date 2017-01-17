package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.services.SolicitudInquilinoService;

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
}
