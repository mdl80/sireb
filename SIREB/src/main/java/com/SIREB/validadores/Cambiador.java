package com.SIREB.validadores;

import com.SIREB.modelos.BarrioZona;
import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.Cuartel;
import com.SIREB.modelos.Grado;
import com.SIREB.modelos.Intervencion;
import com.SIREB.modelos.MotivoBaja;
import com.SIREB.modelos.Movil;
import com.SIREB.modelos.OtrosServicios;
import java.util.Objects;

/**
 * esta clase es responsable de realizar los cambios necesarios para dejar los
 * campos String con la primer letra en mayuscula
 * este cambiador debe mejorarse y dejar el null como null(if dentro del case)
 *
 * @author Marcelo Llanes
 */
public class Cambiador {

  public static void paseMayuscula(Object objeto) {

    if (Objects.nonNull(objeto)) {
      String clase = objeto.getClass().getSimpleName();
      switch (clase) {
        case ("Bombero"): {
          Bombero bombero = (Bombero) objeto;
          bombero.setNombre1(cambiarTodo(bombero.getNombre1()));
          bombero.setNombre2(cambiarTodo(bombero.getNombre2()));
          bombero.setApellido(cambiarTodo(bombero.getApellido()));
          bombero.setDireccion(cambiarTodo(bombero.getDireccion()));
        }
        break;

        case ("Grado"): {
          Grado grado = (Grado) objeto;
          grado.setGrado(cambiarTodo(grado.getGrado()));
          break;
        }
        case ("Cuartel"): {
          Cuartel cuartel = (Cuartel) objeto;
          cuartel.setDireccion(cambiarTodo(cuartel.getDireccion()));
        }
        break;

        case ("BarrioZona"): {
          BarrioZona barrioZona = (BarrioZona) objeto;
          barrioZona.setBarrioZona(cambiarTodo(barrioZona.getBarrioZona()));
        }
        break;

        case ("MotivoBaja"): {
          MotivoBaja motivoBaja = (MotivoBaja) objeto;
          motivoBaja.setMotivo(cambiarUna(motivoBaja.getMotivo()));
          motivoBaja.setDescripcion(cambiarUna(motivoBaja.getDescripcion()));
        }
        break;

        case ("OtrosServicios"): {
          OtrosServicios servicio = (OtrosServicios) objeto;
          servicio.setServicio(cambiarTodo(servicio.getServicio()));
          servicio.setDescripcion(cambiarUna(servicio.getDescripcion()));
        }
        break;

        case ("Movil"): {
          Movil movil = (Movil) objeto;
          movil.setMarca(((movil.getMarca()).toUpperCase()));
          movil.setModelo(cambiarTodo(movil.getModelo()));
        }
        break;
        case("Intervencion"):{
            Intervencion intervencion = (Intervencion) objeto;
            intervencion.setNombreAlertante(cambiarTodo(intervencion.getNombreAlertante()));
            intervencion.setApellidoAlertante(cambiarTodo(intervencion.getApellidoAlertante()));
            intervencion.setDireccion1(cambiarTodo(intervencion.getDireccion1()));
            intervencion.setDireccion2(cambiarTodo(intervencion.getDireccion2()));
        }
        break;
        default: {
        }
      }
    }
  }


  private static String cambiarTodo(String texto) {
    if (Objects.isNull(texto)) {
      return null;
    }
    texto = texto.toLowerCase();
    String resultado = texto;
    String[] temporal = texto.split(" ");

    if (temporal.length >=1 ) {
      for (int i = 0; i < temporal.length; i++) {
        temporal[i] = temporal[i].substring(0, 1).toUpperCase().concat(temporal[i].substring(1));
      }
      resultado = String.join(" ", temporal);
    }else{
      return cambiarUna(texto);
    }
    return resultado;
  }

  private static String cambiarUna(String texto) {
    if (Objects.isNull(texto)) {
      texto = " ";
    }
    texto = texto.toLowerCase();
    String resultado = texto;
    String[] temporal = texto.split(" ");
    temporal[0] = cambiarTodo(temporal[0]);

    resultado = String.join(" ", temporal);

    return resultado;
  }
}
