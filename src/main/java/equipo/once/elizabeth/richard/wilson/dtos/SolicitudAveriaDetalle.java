package equipo.once.elizabeth.richard.wilson.dtos;

import java.util.Date;

public class SolicitudAveriaDetalle {

  public Long id;
  public Date fechaSolicitud;
  public String estatus;
  public String descripcion;
  public String inquilinoNombre;
  public String mobiliarioDescripcion;
  public String ubicacion;
  public String tipoAveria;
  public String tipoIncidente;
  public String tipoTecnico;
  public Long tecnicoId;
  public String tecnico;


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

  public String getMobiliarioDescripcion() {
    return mobiliarioDescripcion;
  }

  public void setMobiliarioDescripcion(String mobiliarioDescripcion) {
    this.mobiliarioDescripcion = mobiliarioDescripcion;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getTipoAveria() {
    return tipoAveria;
  }

  public void setTipoAveria(String tipoAveria) {
    this.tipoAveria = tipoAveria;
  }

  public String getTipoIncidente() {
    return tipoIncidente;
  }

  public void setTipoIncidente(String tipoIncidente) {
    this.tipoIncidente = tipoIncidente;
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

  public String getTecnico() {
    return tecnico;
  }

  public void setTecnico(String tecnico) {
    this.tecnico = tecnico;
  }
}
