package com.SIREB.modelos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * esta clase es la responsable de generar un numero de ticket un numero de
 * ticket es un identificador unico para cada registro de emergencia esta
 * compuesto de la forma
 *
 * @author Marcelo Llanes
 */
public class Ticket {

  private String dia;
  private String mes;
  private String anio;
  private String ticket;
  //utilizado para contabilizar los tickets
  //no discrimina por cuartel
  private  static Integer valor = 0;
  private GregorianCalendar fecha = new GregorianCalendar();
  
  public Ticket(){
      valor++;
  }

  public String getTicket() {
    return getDia() + getMes() + getAnio() + valor;
  }
  
  private String getDia() {
    return String.format("%02d", (fecha.get(Calendar.DATE)));
  }

  private String getMes() {
    return String.format("%02d", (fecha.get(Calendar.MONTH) + 1));
  }

  private String getAnio() {
    return String.valueOf(fecha.get(Calendar.YEAR)).substring(2, 4);
  }

}
