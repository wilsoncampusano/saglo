package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;

public interface MobiliarioService {
  MobiliarioInquilino buscarPorInquilino(Inquilino inquilino);
}
