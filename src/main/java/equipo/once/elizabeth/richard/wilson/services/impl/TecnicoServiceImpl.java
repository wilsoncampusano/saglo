package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.repository.TecnicoRepository;
import equipo.once.elizabeth.richard.wilson.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {
  @Autowired
  TecnicoRepository tecnicoRepository;


  @Override
  public List<Tecnico> buscarTecnicosPorTipo(String tipoTecnico){
    return tecnicoRepository.buscarPorTipo(tipoTecnico);
  }

  @Override
  public Tecnico buscarPorId(Long tecnicoId) {
    return tecnicoRepository.findOne(tecnicoId);
  }
}
