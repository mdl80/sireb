package com.SIREB.modelos;

import java.util.Date;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * esta clase es la responsable de definir una respuesta desde el servicio
 * para que pueda ser consumida a traves del endpoint , la respuesta a enviar
 * contiene datos de fecha del evento o accion, modulo afectado,tipo de acción 
 * y resultado
 * @author Marcelo Llanes
 */
@Getter
@Setter
public class RespuestaAccion {
  
  private Date fecha;
  private String modulo;
  private String tipo;
  private boolean resultado;
  private String mapaErrores;
}
