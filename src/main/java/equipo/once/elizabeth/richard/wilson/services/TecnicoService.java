package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TecnicoService {
  List<Tecnico> buscarTecnicosPorTipo(String tipoTecnico);

  Tecnico buscarPorId(Long tecnicoId);
}
