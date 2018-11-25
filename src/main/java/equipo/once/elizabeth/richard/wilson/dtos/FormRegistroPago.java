package equipo.once.elizabeth.richard.wilson.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class FormRegistroPago {
  public Long inquilinoId;
  public Date fechaPago;
  public BigDecimal monto;
  public String comentario;

  public Long getInquilinoId() {
    return inquilinoId;
  }

  public void setInquilinoId(Long inquilinoId) {
    this.inquilinoId = inquilinoId;
  }

  public Date getFechaPago() {
    return fechaPago;
  }

  public void setFechaPago(Date fechaPago) {
    this.fechaPago = fechaPago;
  }

  public BigDecimal getMonto() {
    return monto;
  }

  public void setMonto(BigDecimal monto) {
    this.monto = monto;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
