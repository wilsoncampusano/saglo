package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.dtos.InquilinoPagoDto;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquilinoService {
  Inquilino buscarPorUsuario(Usuario usuario);

  List<InquilinoPagoDto> inquilinosMobiliario();
}
