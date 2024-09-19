
package com.SIREB.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * esta clase representa los tipos de aviso de emergencia
 * que tiene el cuartel
 * @author marcelo
 */
@Data
@Entity
@Table(name = "TipoAvisos")
public class TipoAviso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoAviso")
    private Integer idTipoAviso;
    
    @Column(name = "avisotipo")
    private String avisoTipo;
    
    @Column(name = "descripcion")
    private String descripcion;
}
