
package com.SIREB.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * esta clase representa los tipos de intervencion
 * que estan definidos por un tipo y un subtipo
 * @author marcelo
 */
@Entity
@Table(name = "TiposIntervenciones")
@Data
public class TipoIntervencion implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "idTipoIntervencion")
    private Integer idTipoIntervencion;
    
    @Column(name = "idTipo")
    private Integer idTipo;
    
    @Column(name = "idSubTipo")
    private Integer idSubTipo;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "descripcion")
    private String descripcion;
}
