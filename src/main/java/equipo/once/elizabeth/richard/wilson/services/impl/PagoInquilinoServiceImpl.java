package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.dtos.FormRegistroPago;
import equipo.once.elizabeth.richard.wilson.dtos.PagoInquilinoDTO;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Pago;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.repository.PagoInquilinoRepository;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioInquilinoService;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoInquilinoServiceImpl implements PagoInquilinoService {

  @Autowired
  PagoInquilinoRepository pagoInquilinoRepository;
  @Autowired
  MobiliarioInquilinoService mobiliarioInquilinoService;

  @Override
  public List<PagoInquilino> pagosPorInquilino(Inquilino entidad) {
    List<PagoInquilino> pagos = new ArrayList<>();

    List<PagoInquilino> pagoInquilinos = pagoInquilinoRepository.byInquilinoId(entidad.id);
    pagos.addAll(pagoInquilinos);
    return pagos;
  }

  @Override
  public void registrar(FormRegistroPago pago) {

    PagoInquilino pagoInquilino = new PagoInquilino();
    pagoInquilino.fechaCuota = pago.fechaPago;
    pagoInquilino.monto = pago.monto;

    Inquilino inquilino = new Inquilino();
    inquilino.id = pago.inquilinoId;
    pagoInquilino.inquilino = inquilino;

    Pago pagoTipo = new Pago();
    pagoTipo.id = 1L;

    pagoInquilino.pago = pagoTipo;

    pagoInquilinoRepository.save(pagoInquilino);

  }


  @Override
  public List<PagoInquilinoDTO> registrados() {
  List<PagoInquilinoDTO> dtos = new ArrayList<>();
    List<PagoInquilino> all = (List<PagoInquilino>)pagoInquilinoRepository.findAll();


    all.stream().forEach(p ->{
      PagoInquilinoDTO pa = new PagoInquilinoDTO();

      MobiliarioInquilino mobiliarioInquilino = mobiliarioInquilinoService.buscar(p.inquilino);

      pa.id = String.valueOf(p.id);
      pa.inquilino = p.inquilino.nombre;
      pa.mobiliario = mobiliarioInquilino.mobiliario.nombre;
      pa.monto = p.monto;
      pa.concepto = p.pago.tipoPago;
      pa.fecha = p.fechaCuota;


      dtos.add(pa);
    });

    return dtos;
  }
}
