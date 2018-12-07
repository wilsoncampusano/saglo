package equipo.once.elizabeth.richard.wilson.services;

import equipo.once.elizabeth.richard.wilson.dtos.FormRegistroPago;
import equipo.once.elizabeth.richard.wilson.dtos.PagoInquilinoDTO;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;

import java.util.List;


public interface PagoInquilinoService {
    List<PagoInquilino> pagosPorInquilino(Inquilino entidad);

    void registrar(FormRegistroPago pago);

    List<PagoInquilinoDTO> registrados();
}
