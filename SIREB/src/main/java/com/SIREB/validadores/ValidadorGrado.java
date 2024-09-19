package com.SIREB.validadores;

import com.SIREB.modelos.Grado;
import com.SIREB.repositorios.RepositorioGrado;
import java.util.HashMap;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Esta clase se encarga de realizar las validaciones correspondientes sobre la
 * clase Grado(campos del modelo) y devuelve un mapa de errores
 *
 * @author Marcelo Llanes
 */
public class ValidadorGrado {

  //mapa de errores interno, va en el mapa de errores
  private HashMap<String, Boolean> listaErrores = new HashMap<>();
  //mapa de errores a devolver
  private HashMap<Boolean, HashMap> errores = new HashMap<>();
  private RepositorioGrado gradoRepositorio;
  
  @Autowired
  public ValidadorGrado(RepositorioGrado gradoRepositorio){
    this.gradoRepositorio = gradoRepositorio;
  }

  /**
   * Esta metodo valida un gradoRepositorio, las comprobaciones que realiza son nombre
 nulo, nombre vacio o en blanco y que no se incluyan caracteres especiales o
 numeros, y que el dato a validar sea un gradoRepositorio
   *
   * @param grado el gradoRepositorio a validar
   * @return un mapa de true, null si el gradoRepositorio es validado, un mapa
 false,hashmap si el gradoRepositorio no es validado, el mapa devuelto contiene todos
 los errores detectados
 <Boolean, mapa de errores>
   */
  public HashMap<Boolean, HashMap> validarGrado(Grado grado) {
    //limpio la lista de errores  y errores,
    errores.clear();
    listaErrores.clear();
    noNulogrado(grado);
    //si es nulo o no es la clase esperada no se deben ejecutar las otras comprobaciones
    if (listaErrores.containsKey("Grado nulo")
      || listaErrores.containsKey("El grado no es de tipo Grado")) {
      errores.put(false, listaErrores);
      return errores;
    } else {
      nombreGrado(grado);
      caracterGrado(grado);
      longitudGrado(grado);
      existeGrado(grado);
    }
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);
      
    } else {
      errores.put(true, listaErrores);
     
    }
    return errores;
  }

  /**
   * este metodo valida que el nombre del gradoRepositorio no sea en blanco o de longitud 0
 si no es validado se lo agrega a un mapa de errores
   *
   * @param grado el gradoRepositorio a validar
   */
  private void nombreGrado(Grado grado) {
    if (grado.getGrado().isEmpty() || grado.getGrado().isBlank()) {
      listaErrores.put("Grado en blanco", false);
    }

  }

  /**
   * este metodo valida que el nombre no incluya numeros o caracteres especiales
   * si no cumple la condicion lo agrega a un mapa de errores
   *
   * @param grado el gradoRepositorio a validar
   */
  private void caracterGrado(Grado grado) {
    if (!grado.getGrado().matches("^[a-zA-ZñÑ]+$")) {
      listaErrores.put("Caracteres invalidos utilizados",false);
    }
  }

  /**
   * este metodo valida que el gradoRepositorio a validar sea de la clase esperada y que no
 sea nulo, si no cumple la condicion de validacion se agrega a un mapa de
 errores
   *
   * @param grado el gradoRepositorio a validar
   */
  private void noNulogrado(Grado grado) {
    if (grado==null) {
      listaErrores.put("Grado nulo", false);
    } else {
      if (!grado.getClass().equals(Grado.class)) {
        listaErrores.put("El grado no es de tipo Grado",false);
      }
    }
  }

  /**
   * este metodovalida la longitud del texto gradoRepositorio, si no cumple con la
 validacion es agregado a un mapa de errores;
   *
   * @param grado
   */
  private void longitudGrado(Grado grado) {
    if (grado.getGrado().length() < 4) {
      listaErrores.put("Nombre de grado corto", false);
    }
  }
  /**
   * este metodo verifica si el nombre de gradoRepositorio ya existe en la base de datos,
 si el gradoRepositorio ya existe no puede agregarse un gradoRepositorio con el mismo nombre
   * @param grado  el gradoRepositorio a validar
   */
  private void existeGrado(Grado grado){
    if(gradoRepositorio.existeGrado(grado.getGrado())==1){
      listaErrores.put("El grado ya existe", false);
    }
  }

  /**
   * este metodo valida un id de gradoRepositorio
   *
   * @param idGrado el id a validar
   * @return un mapa de errores
   */
  public HashMap<Boolean, HashMap> validarGrado(Integer idGrado) {

    HashMap<Boolean, HashMap> errores = new HashMap<>();
    idValido(idGrado);
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);
    } else {
      errores.put(true, listaErrores);
    }

    return errores;
  }

  /**
   * verifica que un id de gradoRepositorio no sea nulo o negativo 
   *
   * @param idGrado
   */
  private void idValido(Integer idGrado) {
    if (Objects.isNull(idGrado)) {
      listaErrores.put("Id nulo", false);
    } else  if (idGrado <= 0) {
        listaErrores.put("Id menor o igual a 0", false);
      } else  if (!gradoRepositorio.existsById(idGrado)){
          listaErrores.put("El Id de grado no existe", false);
        }
      }
    }
  

