package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.PagoInquilino;
import equipo.once.elizabeth.richard.wilson.services.PagoInquilinoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wicampusano on 1/11/2017.
 */
public class InquilinoServiceUnPagoMock implements PagoInquilinoService {
    public static List<PagoInquilino> pagos = new ArrayList<>();

    static{
        PagoInquilino pago = new PagoInquilino();
        pagos.add(pago);
    }
    @Override
    public List<PagoInquilino> pagosPorEstadoDesdeFecha(String estado, String fecha) {
        return pagos;
    }
}
