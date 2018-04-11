package equipo.once.elizabeth.richard.wilson.services.impl;


import equipo.once.elizabeth.richard.wilson.controllers.view.util.DateUtil;
import equipo.once.elizabeth.richard.wilson.entities.dao.SolicitudAveriaRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Estatus;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.TipoSolicitud;
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
        List<ListaSolicitudInquilinoDetalleForm> listas = new ArrayList<>();

        List<SolicitudCasoAveria> solicitudCasoAverias =
                solicitudAveriaRepository.buscarSolicitudesDelInquilino(inquilino.id);

        for(SolicitudCasoAveria s: solicitudCasoAverias){
            ListaSolicitudInquilinoDetalleForm l = new ListaSolicitudInquilinoDetalleForm();
            l.estatus = s.estatus;
            l.tipoSolicitud = TipoSolicitud.SOLICITUD_AVERIA;
            l.id = s.id;
            l.descripcion = String.format("Solicitud caso averia en fecha %s Nota : %s", DateUtil.toString(s.fechaSolicitud), s.comentario);
        }
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
        averia.estatus = Estatus.PENDIENTE;

        SolicitudCasoAveria save = solicitudAveriaRepository.save(averia);

    }
}
