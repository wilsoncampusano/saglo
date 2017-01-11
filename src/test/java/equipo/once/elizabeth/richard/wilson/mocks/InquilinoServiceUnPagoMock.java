package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Entidad;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class InquilinoServiceUnPagoMock implements PagoInquilinoService {
    public static List<PagoInquilino> pagos = new ArrayList<>();

    static{
        PagoInquilino pago = new PagoInquilino();
        Inquilino inquilino = new InquilinoMock();
        pago.inquilino = inquilino;
        pagos.add(pago);
    }
    @Override
    public List<PagoInquilino> pagosPorEntidadDesdeFecha(Entidad entidad, String fecha) {
        pagos = pagos
                .stream()
                .filter(pa -> pa.inquilino.getCodigo().equals(entidad.getCodigo()))
                .collect(Collectors.toList());
        return pagos;
    }
}
