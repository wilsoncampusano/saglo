package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.dtos.InquilinoPagoDto;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.repository.InquilinoRepository;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.InquilinoService;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioInquilinoService;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InquilinoServiceImpl implements InquilinoService {

  @Autowired
  private InquilinoRepository inquilinoRepository;
  @Autowired
  private MobiliarioInquilinoService mobiliarioInquilinoService;


  @Override
  public Inquilino buscarPorUsuario(Usuario usuario) {

    Inquilino inquilino = inquilinoRepository.bucarPorUsuario(usuario.username);
    return inquilino;
  }

  @Override
  public List<InquilinoPagoDto> inquilinosMobiliario() {
    List<InquilinoPagoDto> inquilinoPagoDtos = new ArrayList<>();
    List<Inquilino> activos = inquilinoRepository.activos();

    activos.stream().forEach(i ->{
      MobiliarioInquilino mobiliarioInquilino = mobiliarioInquilinoService.buscar(i);
      InquilinoPagoDto inquilinoPagoDto = new InquilinoPagoDto();
      inquilinoPagoDto.inquilinoId = i.id;
      inquilinoPagoDto.inquilinoNombre = i.nombre;

      if(mobiliarioInquilino != null){
        inquilinoPagoDto.inquilinoMobiliario = mobiliarioInquilino.mobiliario.nombre;
        inquilinoPagoDtos.add(inquilinoPagoDto);
      }

    });

    return inquilinoPagoDtos;
  }
}
