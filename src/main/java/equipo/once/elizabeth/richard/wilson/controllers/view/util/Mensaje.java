package equipo.once.elizabeth.richard.wilson.controllers.view.util;

/**
 * Created on 4/9/2018.
 */
public class Mensaje {

    public static final String DANGER ="danger";
    public static final String WARNING ="warning";
    public static final String SUCCESS ="success";

    public static final Mensaje ERROR = new Mensaje(DANGER);
    public static final Mensaje ADVERTENCIA = new Mensaje(WARNING);
    public static final Mensaje EXITO = new Mensaje(SUCCESS);

    private Mensaje(String tipo) {
        this.tipo = tipo;
    }

    public Mensaje() {
    }

    private String tipo;
    private String mensaje;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
