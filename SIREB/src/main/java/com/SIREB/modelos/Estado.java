package com.SIREB.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * esta clase es responsable de los estados de los vehiculos
 * @author Marcelo Llanes
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Estados")
public class Estado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idEstado")
  private Integer idEstado;
  
  @Column(name = "estado")
  private String estado;
  
  @Column(name = "descripcion")
  private String descripcion; 
}
