package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.repository.TecnicoRepository;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.SolicitudAveriaService;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {
  @Autowired
  TecnicoRepository tecnicoRepository;

  @Autowired
  SolicitudAveriaService solicitudAveriaService;


  @Override
  public List<Tecnico> buscarTecnicosPorTipo(String tipoTecnico){
    return tecnicoRepository.buscarPorTipo(tipoTecnico);
  }

  @Override
  public Tecnico buscarPorId(Long tecnicoId) {
    return tecnicoRepository.findOne(tecnicoId);
  }

  @Override
  public Tecnico buscarPorUsuario(Usuario usuario) {
    return tecnicoRepository.buscarPorUsuario(usuario.getId());
  }

  @Override
  public List<SolicitudCasoAveria> buscarAverias(Tecnico tecnico) {
    return solicitudAveriaService.buscarPendientesAsignadasA(tecnico);
  }
}
