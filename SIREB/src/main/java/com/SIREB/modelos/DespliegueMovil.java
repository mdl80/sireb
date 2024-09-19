package com.SIREB.modelos;

import java.io.Serializable;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * esta clase representa los despliegues de moviles por intervencion,los bomberos por 
 * movil por intervencion se encuentran en DespliegueBomberos
 * @author Marcelo Llanes
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "DespliegueMoviles")
public class DespliegueMovil implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idDespliegueMovil")
  private Integer idDespliegueMovil;
  
  @Column(name ="ticket")
  private String ticket;
  
  @Column(name = "idMovil")
  private Integer idMovil;
  
  @Column(name = "horaSalida")
  private LocalDateTime horaSalida;
  
  @Column(name = "horaLlegada")
  private LocalDateTime horaLlegada;
  
  @Column(name = "idIntervencion")
  private Integer idIntervencion;
  
  @ElementCollection(fetch = FetchType.LAZY)
  @JoinColumn(name = "idDespliegueMovil")
  @OneToMany
  @Column(name = "DespliegueBomberos")
  private List<DespliegueBombero> DespliegueBomberos;

}
