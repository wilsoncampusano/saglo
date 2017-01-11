package equipo.once.elizabeth.richard.wilson.entities.dominio;

/**
 * Created by wicampusano on 1/11/2017.
 */
public abstract class Entidad {
    private String codigo;

    public String getCodigo(){
        return this.codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
}
