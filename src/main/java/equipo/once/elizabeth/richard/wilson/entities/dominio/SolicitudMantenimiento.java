package equipo.once.elizabeth.richard.wilson.entities.dominio;


import javax.persistence.*;

@Entity
@Table(name = "solicitud_mantenimiento")
public class SolicitudMantenimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  @ManyToOne
  public Tecnico tecnico;
  @ManyToOne
  public Mantenimiento mantenimiento;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Tecnico getTecnico() {
    return tecnico;
  }

  public void setTecnico(Tecnico tecnico) {
    this.tecnico = tecnico;
  }

  public Mantenimiento getMantenimiento() {
    return mantenimiento;
  }

  public void setMantenimiento(Mantenimiento mantenimiento) {
    this.mantenimiento = mantenimiento;
  }
}
