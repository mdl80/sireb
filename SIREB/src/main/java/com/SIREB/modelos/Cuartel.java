
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

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Cuarteles")

public class Cuartel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuartel")
    private Integer idCuartel;
    
    @Column(name = "regionalNumero")
    private Integer regionalNumero;

    @Column(name = "cuartelNumero")
    private Integer cuartelNumero;

    @Column(name = "direccion")    
    private String direccion;
    
    @Column(name = "jefeCuartel")
    private Integer jefeCuartel;

    @Column(name = "logo")    
    private String logo;
    
}
