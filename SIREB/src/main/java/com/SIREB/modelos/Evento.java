package com.SIREB.modelos;

/**
 *
 * @author Kike
 */

import java.util.Date;
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
@Table(name = "Eventos")
 
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEventos")   
    private Integer idEventos;
    
    @Column(name = "Tipo")
    private String Tipo;

    @Column(name = "Mensaje")
    private String Mensaje;

    @Column(name = "Fecha")
    private Date Fecha;
    
    @Column(name = "idBombero")
    private Integer idBombero;

    public Evento(String Tipo, String Mensaje, Date Fecha, Integer idBombero){
        this.Tipo = Tipo;
        this.Mensaje = Mensaje;
        this.Fecha = Fecha;
        this.idBombero = idBombero;
    
    }
    public Evento(String Tipo, String Mensaje, Integer idBombero){
        Date ahora = new Date();
        this.Tipo = Tipo;
        this.Mensaje = Mensaje;
        this.Fecha = ahora;
        this.idBombero = idBombero;
    
    }

}
