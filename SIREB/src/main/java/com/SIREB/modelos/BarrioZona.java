
package com.SIREB.modelos;

/**
 *
 * @author kike
 */
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
@Table(name = "BarriosZonas")

public class BarrioZona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBarrioZona")
    private Integer idBarrioZona;

    @Column(name = "barrioZona")
    private String barrioZona;

    @Column(name = "jurisdiccion")
    private Boolean jurisdiccion;
    
}
