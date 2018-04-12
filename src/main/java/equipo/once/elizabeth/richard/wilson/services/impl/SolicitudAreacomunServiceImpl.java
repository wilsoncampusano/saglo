package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.DateUtil;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.repository.SolicitudAreaComunRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.*;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaComunForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/9/2018.
 */
@Service
public class SolicitudAreacomunServiceImpl implements SolicitudAreacomunService {

    @Autowired
    private SolicitudAreaComunRepository solicitudAreaComunRepository;

    @Autowired
    private AreaComunService areaComunService;


    @Override
    public void guardar(SolicitudAreaComunForm form) {
        SolicitudAreacomun s = new SolicitudAreacomun();
        AreaComun areaComun = areaComunService.buscarPorCodigo(form.areaComun.getCodigo());
        s.setFechaSolicitud(form.fechaSolicitud);
        s.setAreaComun(areaComun);
        s.setInquilino(form.inquilino);
        s.comentario = form.comentario;
        s.estatus = Estatus.PENDIENTE;
        SolicitudAreacomun save = solicitudAreaComunRepository.save(s);

    }

    @Override
    public boolean isAreaComunDisponible(SolicitudAreaComunForm form) {

        boolean disponibilidad = areaComunService
            .disponibleALafecha(form.areaComun.codigo, form.fechaSolicitud);
        return disponibilidad;
    }

    @Override
    public List<ListaSolicitudInquilinoDetalleForm> buscarSolicitudesDelInquilino(Inquilino inquilino) {
        List<SolicitudAreacomun> solicitudAreacomuns =
            solicitudAreaComunRepository.buscarSolicitudesDelInquilino(inquilino.getId());
        List<ListaSolicitudInquilinoDetalleForm> listas = new ArrayList<>();
        for(SolicitudAreacomun s : solicitudAreacomuns){
            ListaSolicitudInquilinoDetalleForm lista = new ListaSolicitudInquilinoDetalleForm();

            lista.tipoSolicitud= TipoSolicitud.SOLICITUD_AREACOMUN;
            lista.descripcion = String.format(" Solicitud del Area %s para la Fecha: %s \n" +
                    " Nota :  ", s.areaComun.nombre, DateUtil.toString(s.fechaSolicitud ), s.comentario);
            lista.estatus =  s.estatus;
            lista.id = s.id;
            listas.add(lista);
        }
        return listas;
    }

    @Override
    public List<SolicitudAreaDetalle> buscarTodasLasSolicitudesAreaPendientes() {
        List<SolicitudAreaDetalle> detalles = new ArrayList<>();

        List<SolicitudAreacomun> solicitudAreacomun =
            solicitudAreaComunRepository.buscarTodasLasPendientesYEnProceso(Estatus.COMPLETADA);

        for(SolicitudAreacomun sa : solicitudAreacomun){
            SolicitudAreaDetalle d = new SolicitudAreaDetalle();
            d.id = sa.id;
            d.fechaSolicitud = sa.fechaSolicitud;
            d.estatus = sa.estatus;
            d.descripcion = sa.comentario;

            detalles.add(d);
        }
        return detalles;
    }

    @Override
    public SolicitudAreaDetalle buscarSolicitudPorId(Long solicitudId) {
        SolicitudAreacomun one = solicitudAreaComunRepository.findOne(solicitudId);
        SolicitudAreaDetalle detalle = new SolicitudAreaDetalle();

        detalle.id = one.id;
        detalle.descripcion = one.comentario;
        detalle.estatus = one.estatus;
        detalle.fechaSolicitud = one.fechaSolicitud;

        return detalle;
    }
}
