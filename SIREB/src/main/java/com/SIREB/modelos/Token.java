package com.SIREB.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * esta clase es responsable de guardar el token generado 
 * en el servicio usuarioContraseña
 * @author Marcelo Llanes
 */
@Getter
@Setter
@NoArgsConstructor
public class Token {
  //nombre del header
  private final static String  token = "sirebtoken";
  
  //valor del header
  private String llave = null;


}
