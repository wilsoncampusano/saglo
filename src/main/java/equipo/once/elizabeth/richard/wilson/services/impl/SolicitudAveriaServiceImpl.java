package equipo.once.elizabeth.richard.wilson.services.impl;


import equipo.once.elizabeth.richard.wilson.controllers.view.util.DateUtil;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.*;
import equipo.once.elizabeth.richard.wilson.repository.SolicitudAveriaRepository;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioInquilinoService;
import equipo.once.elizabeth.richard.wilson.services.CatalogoService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudCasoAveriaForm;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class SolicitudAveriaServiceImpl implements SolicitudAveriaService {

    Logger logger = Logger.getLogger(SolicitudAveriaServiceImpl.class.getName());

    @Autowired
    SolicitudAveriaRepository solicitudAveriaRepository;

    @Autowired
    CatalogoService catalogoService;

    @Autowired
    MobiliarioInquilinoService mobiliarioInquilinoService;

    @Autowired
    TecnicoService tecnicoService;

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
            listas.add(l);
        }
        return listas;
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

        try{
        SolicitudCasoAveria save = solicitudAveriaRepository.save(averia);
        }catch(Exception e ){
            logger.severe(String.format("Error guardando SAGLO : %s ",e.getMessage()));
        }

    }

    @Override
    public List<SolicitudAveriaDetalle> buscarTodasLasSolicitudesAveriasPendiente() {
        List<SolicitudAveriaDetalle> detalles = new ArrayList<>();

        List<SolicitudCasoAveria> solicitudCasoAverias =
            solicitudAveriaRepository.buscarTodasLasPendientesYEnProceso(Estatus.COMPLETADA);

        for(SolicitudCasoAveria sa : solicitudCasoAverias){
          SolicitudAveriaDetalle d = new SolicitudAveriaDetalle();
            d.id = sa.id;
            d.fechaSolicitud = sa.fechaSolicitud;
            d.estatus = sa.estatus;
            d.descripcion = sa.comentario;
            d.tecnico = String.format("%s / %s", Objects.isNull(sa.tecnico) ? "": sa.tecnico.nombre , Objects.nonNull(sa.tecnico)? sa.tecnico.tipo : "");
            detalles.add(d);
        }
        return detalles;
    }

    @Override
    public SolicitudAveriaDetalle buscarSolicitudPorId(Long averiaId) {
        SolicitudCasoAveria one = solicitudAveriaRepository.findOne(averiaId);
        Catalogo ubicacion = catalogoService.buscarUbicacion(one.ubicacionId);
        Catalogo tipoAveria = catalogoService.buscarTipoAveria(one.tipoAveriaId);
        Catalogo tipoIncidente = catalogoService.buscarTipoIncidente(one.tipoIncidenteId);
        MobiliarioInquilino mobiliarioInquilino = mobiliarioInquilinoService.buscar(one.inquilino);


        SolicitudAveriaDetalle detalle = new SolicitudAveriaDetalle();

        detalle.id = one.id;
        detalle.descripcion = one.comentario;
        detalle.estatus = one.estatus;
        detalle.fechaSolicitud = one.fechaSolicitud;
        detalle.inquilinoNombre = one.inquilino.nombre;
        detalle.mobiliarioDescripcion = String.format("%s %s: %s", mobiliarioInquilino.mobiliario.codigo, mobiliarioInquilino.mobiliario.nombre, mobiliarioInquilino.mobiliario.descripcion);
        detalle.ubicacion = ubicacion.nombre;
        detalle.tipoAveria = tipoAveria.nombre;
        detalle.tipoIncidente = tipoIncidente.nombre;
        detalle.comentario = one.comentarioSolucion;


        return detalle;
    }

    @Override
    public void asignar(SolicitudAveriaDetalle solicitudAveriaDetalle) {
        SolicitudCasoAveria one = solicitudAveriaRepository.findOne(solicitudAveriaDetalle.id);
        Tecnico tecnico = tecnicoService.buscarPorId(solicitudAveriaDetalle.tecnicoId);
        one.tecnico = tecnico;
        solicitudAveriaRepository.save(one);
    }

    @Override
    public void cambiarEstado(String proceso, Long solicitudAveriaDetalle) {
        SolicitudCasoAveria one = solicitudAveriaRepository.findOne(solicitudAveriaDetalle);
        one.estatus = proceso;
        solicitudAveriaRepository.save(one);
    }

    @Override
    public void comentario(String comentario, Long id) {
        SolicitudCasoAveria one = solicitudAveriaRepository.findOne(id);
        one.comentarioSolucion = comentario;
        solicitudAveriaRepository.save(one);
    }

    @Override
    public List<SolicitudCasoAveria> buscarPendientesAsignadasA(Tecnico tecnico) {
        return solicitudAveriaRepository.buscarAsignadasA(tecnico.getId());
    }
}
