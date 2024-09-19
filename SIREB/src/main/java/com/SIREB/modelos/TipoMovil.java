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
@Entity
@Table(name = "TiposMoviles")

public class TipoMovil implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMovil")
    private Integer idTipoMovil;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
}
