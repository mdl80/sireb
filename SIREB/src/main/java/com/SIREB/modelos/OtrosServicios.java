package com.SIREB.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * esta clase representa los servicios externos que participan en una intervencion
 * ,la clase solo tiene como atributo un nombre y una descripcion
 * @author Marcelo Llanes
 */
@Entity
@Getter
@Setter
@Table(name = "OtrosServicios")
public class OtrosServicios implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idOtroServicio")
  private Integer idOtrosServicios;
  @Column(name = "servicio", nullable = false)
  private String servicio;
  @Column(name = "descripcion")
  private String descripcion;

}