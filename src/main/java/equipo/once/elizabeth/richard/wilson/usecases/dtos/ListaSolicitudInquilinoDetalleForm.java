package equipo.once.elizabeth.richard.wilson.usecases.dtos;

public class ListaSolicitudInquilinoDetalleForm {

  public String tipoSolicitud;
  public String estatus;
  public String descripcion;


  public String getTipoSolicitud() {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(String tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  public String getEstatus() {
    return estatus;
  }

  public void setEstatus(String estatus) {
    this.estatus = estatus;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
