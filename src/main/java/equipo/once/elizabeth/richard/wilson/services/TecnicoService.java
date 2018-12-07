package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAreaDetalle;
import equipo.once.elizabeth.richard.wilson.dtos.SolicitudAveriaDetalle;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudCasoAveria;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TecnicoService {
  List<Tecnico> buscarTecnicosPorTipo(String tipoTecnico);

  Tecnico buscarPorId(Long tecnicoId);


  Tecnico buscarPorUsuario(Usuario usuario);

  List<SolicitudCasoAveria> buscarAverias(Tecnico tecnico);

  SolicitudAveriaDetalle buscarAveria(Long averiaId, Tecnico tecnico);
}
