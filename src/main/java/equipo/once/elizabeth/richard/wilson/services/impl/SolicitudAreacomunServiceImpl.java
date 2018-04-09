package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.SolicitudAreaComunRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudAreacomun;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAreacomunService;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.SolicitudAreaComunForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        SolicitudAreacomun save = solicitudAreaComunRepository.save(s);

    }
}
