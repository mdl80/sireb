package com.SIREB.modelos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Kike
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Sesion {
    private String key;
    private Integer idBombero;
    private Integer idCuartel;
    private Date inicio;
    private Date UltimoCambio;
}
