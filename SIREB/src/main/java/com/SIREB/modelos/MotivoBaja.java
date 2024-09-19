package com.SIREB.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Motivosbajas")
public class MotivoBaja {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idMotivoBaja")
  Integer idMotivoBaja;
  
  @Column(name = "motivo")
  String motivo;
  
  @Column(name = "descripcion")
  String descripcion;

}

