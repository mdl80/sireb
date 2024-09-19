package com.SIREB.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Wanda
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Moviles")
public class Movil implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idmovil")
  private Integer idMovil;

  @Column(name = "numeroMovil")
  private Integer numeroMovil;

  @Column(name = "marca")
  private String marca;

  @Column(name = "modelo")
  private String modelo;

  @Column(name = "plaza")
  private Integer plaza;

  @Column(name = "idTipoBomba")
  private Integer idTipoBomba;

  @Column(name = "idEstadoMovil")
  private Integer idEstadoMovil;

  @Column(name = "idTipoMovil")
  private Integer idTipoMovil;

}
