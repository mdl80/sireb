package com.SIREB.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

/**
 * esta clase es la responsable de almacenar los datos correspondientes a una
 * intervención
 *
 * @author Marcelo Llanes
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Intervenciones")
public class Intervencion implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idIntervencion")
  private Integer idIntervencion;

  @Column(name = "ticket")
  private String ticket;
  
  @Column(name = "fecha")
  private LocalDate fecha;
  
  @Column(name = "horaInicio")
  private LocalDateTime horaInicio;
  
  @Nullable
  @Column(name = "horaFin")
  private LocalDateTime horaFin;
  
  @Column(name = "horaLlamado")
  private LocalDateTime horaLlamado;//hora de llamado del alertante
  
  @Column(name = "nombreAlertante")
  private String nombreAlertante;
  
  @Column(name = "apellidoAlertante")
  private String apellidoAlertante;
  
  @Column(name = "contactoAlertante")
  private String contactoAlertante;
  
  @Column(name = "direccion1")
  private String direccion1;
  
  @Nullable
  @Column(name = "direccion2")
  private String direccion2;
  
  @Nullable
  @Column(name = "informeIntervencion")
  private String informeIntervencion;
  
  @Column(name = "idTipoAviso")
  private Integer idTipoAviso;
  
  @Nullable//podemos hacer que por defecto se setee en curso
  @Column(name = "idEstado")
  private Integer idEstado;
  
  @Column(name = "idBarrioZona")
  private Integer idBarrioZona;
  
  /*
  se elimina FK de la tabla intervenciones, reveer
  @Nullable
  @Column(name = "idModificado")
  private Integer idModificado;
  */
  @Column(name = "idjefeBrigada")
  private Integer idJefeBrigada;
  
  @Column(name = "idTipoIntervencion")
  private Integer idTipoIntervencion;
  
  @Column(name = "idMovilRespuesta")
  private Integer idMovilRespuesta;
  
  @ElementCollection(fetch=FetchType.LAZY)
  @JoinColumn(name="idIntervencion")
  @OneToMany
  @Column(name = "DespliegueMoviles")
  private List<DespliegueMovil> despliegueMoviles;
}
