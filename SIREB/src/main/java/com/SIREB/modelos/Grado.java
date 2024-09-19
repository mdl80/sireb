package com.SIREB.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa los grados jerarquicos de los bomberos
 *
 * @author Marcelo Llanes
 */
@Getter
@Setter
@Entity
@Table(name = "Grados")
public class Grado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idGrado")
  private Integer idGrado;

  @Column(name = "grado")
  private String grado;

}
