package equipo.once.elizabeth.richard.wilson.entities.dao.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepository;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AreaComunInMemoryRepository implements AreaComunRepository{

  AreaComun piscina = AreaComun.crear("A-piscina-1","Piscina");
  AreaComun areaBBQ = AreaComun.crear("A-BBQ-1", "BBQ");
  List<AreaComun> areasComunes = Arrays.asList(piscina, areaBBQ);


  @Override
  public List<AreaComun> buscarPorPalabra(String palabra) {
    return
        areasComunes
            .stream()
            .filter(a -> a.nombre.toLowerCase().contains(palabra.toLowerCase()))
            .collect(Collectors.toList());
  }
}
