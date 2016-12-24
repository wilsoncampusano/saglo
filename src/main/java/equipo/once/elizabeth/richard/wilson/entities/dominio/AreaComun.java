package equipo.once.elizabeth.richard.wilson.entities.dominio;


public class AreaComun {
  public boolean estaDisponible;
  public String nombre;
  public String codigo;

  public static AreaComun crear(String codigo, String nombre) {
    AreaComun areaComun = new AreaComun();
    areaComun.nombre = nombre;
    areaComun.codigo = codigo;
    return areaComun;
  }
}
