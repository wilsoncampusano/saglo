package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pago_inquilino")
@Cacheable(false)
public class PagoInquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @ManyToOne
    public Inquilino inquilino;

    @ManyToOne
    public Pago pago;


    public Date fechaCuota;

    public BigDecimal monto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }


}
