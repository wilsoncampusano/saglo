package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.services.SolicitudInquilinoService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudInquilinoServiceUnaSolicitudMock implements SolicitudInquilinoService{
    static List<SolicitudAreacomun> solicitudesInquilino = new ArrayList<SolicitudAreacomun>();

    static {
        SolicitudAreacomun solicitudAreacomun = new SolicitudAreacomun();
        Inquilino inquilino = new InquilinoMock();
        solicitudAreacomun.inquilino = inquilino;
        solicitudesInquilino.add(solicitudAreacomun);
    }

    @Override
    public List<SolicitudAreacomun> buscarSolicitudesDe(Inquilino inquilino) {
        return solicitudesInquilino
                .stream()
                .filter(s -> s.inquilino.equals(inquilino))
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudAreacomun guardar(SolicitudAreaComunForm form) {
        SolicitudAreacomun solicitudAreacomun = new SolicitudAreacomun();
        solicitudAreacomun.inquilino = form.inquilino;
        solicitudAreacomun.areaComun = form.areaComun;
        solicitudAreacomun.fechaSolicitud = form.fechaSolicitud;
        solicitudesInquilino.add(solicitudAreacomun);

        return solicitudAreacomun;
    }
}
