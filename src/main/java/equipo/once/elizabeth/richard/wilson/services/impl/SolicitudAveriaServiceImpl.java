package equipo.once.elizabeth.richard.wilson.services.impl;


import equipo.once.elizabeth.richard.wilson.entities.dao.SolicitudAveriaRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudCasoAveriaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SolicitudAveriaServiceImpl implements SolicitudAveriaService {

    @Autowired
    SolicitudAveriaRepository solicitudAveriaRepository;

    @Override
    public List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino) {
        List<SolicitudCasoAveria> solicitudCasoAverias =
                solicitudAveriaRepository.buscarSolicitudesDelInquilino(inquilino.id);

        return new ArrayList<>();
    }

    @Override
    public void guardar(SolicitudCasoAveriaForm form) {
        SolicitudCasoAveria averia = new SolicitudCasoAveria();


        averia.inquilino = form.inquilino;
        averia.fechaSolicitud = new Date();
        averia.ubicacionId = form.ubicacionId;
        averia.tipoAveriaId = form.tipoAveriaId;
        averia.tipoIncidenteId = form.tipoIncidenteId;
        averia.comentario = form.comentario;

        SolicitudCasoAveria save = solicitudAveriaRepository.save(averia);

    }
}
