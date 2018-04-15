package equipo.once.elizabeth.richard.wilson.dtos;

import java.util.Date;

public class SolicitudAreaDetalle {
  public Long id;
  public Date fechaSolicitud;
  public String estatus;
  public String descripcion;
  public String inquilinoNombre;
  public String areacomunNombre;
  public String mobiliarioNombre;
  public String tipoTecnico;
  public Long tecnicoId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getFechaSolicitud() {
    return fechaSolicitud;
  }

  public void setFechaSolicitud(Date fechaSolicitud) {
    this.fechaSolicitud = fechaSolicitud;
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

  public String getInquilinoNombre() {
    return inquilinoNombre;
  }

  public void setInquilinoNombre(String inquilinoNombre) {
    this.inquilinoNombre = inquilinoNombre;
  }

  public String getAreacomunNombre() {
    return areacomunNombre;
  }

  public void setAreacomunNombre(String areacomunNombre) {
    this.areacomunNombre = areacomunNombre;
  }

  public String getMobiliarioNombre() {
    return mobiliarioNombre;
  }

  public void setMobiliarioNombre(String mobiliarioNombre) {
    this.mobiliarioNombre = mobiliarioNombre;
  }

  public String getTipoTecnico() {
    return tipoTecnico;
  }

  public void setTipoTecnico(String tipoTecnico) {
    this.tipoTecnico = tipoTecnico;
  }

  public Long getTecnicoId() {
    return tecnicoId;
  }

  public void setTecnicoId(Long tecnicoId) {
    this.tecnicoId = tecnicoId;
  }
}
