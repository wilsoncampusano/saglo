package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.DateUtil;
import equipo.once.elizabeth.richard.wilson.entities.dao.SolicitudAreaComunRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.*;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.ListaSolicitudInquilinoDetalleForm;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
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
        Inquilino inquilino = new Inquilino();
        inquilino.setId(1L);
        s.setFechaSolicitud(form.fechaSolicitud);
        s.setAreaComun(areaComun);
        s.setInquilino(inquilino);
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
}
