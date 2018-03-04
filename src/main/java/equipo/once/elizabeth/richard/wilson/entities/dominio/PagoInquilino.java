package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "pago_inquilino")
public class PagoInquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public Inquilino inquilino;
    public String estado;
}
