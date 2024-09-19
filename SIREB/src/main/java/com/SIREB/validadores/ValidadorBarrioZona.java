package com.SIREB.validadores;

import com.SIREB.modelos.BarrioZona;
import com.SIREB.modelos.Grado;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.repositorios.RepositorioGrado;
import java.util.HashMap;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Esta clase se encarga de realizar las validaciones correspondientes sobre la
 * clase BarrioZona(campos del modelo) y devuelve un mapa de errores
 *
 * @author Marcelo Llanes
 */
public class ValidadorBarrioZona {

  //mapa de errores interno, va en el mapa de errores
  private HashMap<String, Boolean> listaErrores = new HashMap<>();
  //mapa de errores a devolver
  private HashMap<Boolean, HashMap> errores = new HashMap<>();
  private RepositorioBarrioZona repositorioBarrioZona;
  
  @Autowired
  public ValidadorBarrioZona(RepositorioBarrioZona repositorioBarrioZona){
    this.repositorioBarrioZona = repositorioBarrioZona;
  }

  /**
   * Esta metodo valida un gradoRepositorio, las comprobaciones que realiza son nombre
 nulo, nombre vacio o en blanco y que no se incluyan caracteres especiales o
 numeros, y que el dato a validar sea un gradoRepositorio
   *
   * @param barrioZona el gradoRepositorio a validar
   * @return un mapa de true, null si el gradoRepositorio es validado, un mapa
 false,hashmap si el gradoRepositorio no es validado, el mapa devuelto contiene todos
 los errores detectados
 <Boolean, mapa de errores>
   */
  public HashMap<Boolean, HashMap> validarBarrioZona(BarrioZona barrioZona,Accion accion) {

    noNuloBarrio(barrioZona);
    //si es nulo o no es la clase esperada no se deben ejecutar las otras comprobaciones
    if (listaErrores.containsKey("Barrio o zona nulo")
      || listaErrores.containsKey("El Barrio o zona no es de tipo BarrioZona")) {
      errores.put(false, listaErrores);
      return errores;
    } 
    if(accion.equals(Accion.AGREGAR)){
      nombreBarrio(barrioZona);
      caracterBarrio(barrioZona);
      longitudBarrio(barrioZona);
      existeBarrio(barrioZona);
      jurisdiccion(barrioZona);
    }
    if(accion.equals(Accion.ELIMINAR)){
      nombreBarrio(barrioZona);
      caracterBarrio(barrioZona);
      longitudBarrio(barrioZona);
      noExisteBarrio(barrioZona);
    }
    if(accion.equals(Accion.ACTUALIZAR)){
      nombreBarrio(barrioZona);
      caracterBarrio(barrioZona);
      longitudBarrio(barrioZona);
      jurisdiccion(barrioZona);
    }
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);
      
    } else {
      errores.put(true, listaErrores);
     
    }
    return errores;
  }

  /**
   * este metodo valida que el nombre del barrio no sea en blanco o de longitud 0
 si no es validado se lo agrega a un mapa de errores
   *
   * @param barrio el BarrioZona a validar
   */
  private void nombreBarrio(BarrioZona barrio) {
    if (barrio.getBarrioZona().isEmpty() || barrio.getBarrioZona().isBlank()) {
      listaErrores.put("Barrio/Zona en blanco", false);
    }

  }

  /**
   * este metodo valida que el nombre no incluya numeros o caracteres especiales
   * si no cumple la condicion lo agrega a un mapa de errores
   *
   * @param barrio el barrio a validar
   */
  private void caracterBarrio(BarrioZona barrio) {
    if (!barrio.getBarrioZona().matches("^[a-zA-ZñÑ0-9 ]+$")) {
      listaErrores.put("Caracteres invalidos utilizados",false);
    }
  }

  /**
   * este metodo valida que el barrio a validar sea de la clase esperada y que no
 sea nulo, si no cumple la condicion de validacion se agrega a un mapa de
 errores
   *
   * @param barrio el barrio a validar
   */
  private void noNuloBarrio(BarrioZona barrio) {
    if (Objects.isNull(barrio)) {
      listaErrores.put("Barrio nulo", false);
    } else {
      if (!barrio.getClass().equals(BarrioZona.class)) {
        listaErrores.put("El barrio no es de tipo BarrioZona",false);
      }
    }
  }

  /**
   * este metodovalida la longitud del texto barrio, si no cumple con la
 validacion es agregado a un mapa de errores;
   *
   * @param barrio
   */
  private void longitudBarrio(BarrioZona barrio) {
    if (barrio.getBarrioZona().length() < 4) {
      listaErrores.put("Nombre de barrio o zona corto", false);
    }
  }
  /**
   * este metodo verifica si el nombre de barrio ya existe en la base de datos,
   * si el barrio ya existe no puede agregarse un barrio con el mismo nombre
   * @param barrio  el barrio a validar
   */
  private void existeBarrio(BarrioZona barrio){
    if(repositorioBarrioZona.existsByBarrioZona(barrio.getBarrioZona())){
      listaErrores.put("El barrio ya existe", false);
    }
  }
  /**
   * este metodo evalua si el barrio no existe, se utiliza para validar una
   * eliminacion
   * @param barrio el barrio a validar
   */
  private void noExisteBarrio(BarrioZona barrio){
    if(!repositorioBarrioZona.existsByBarrioZona(barrio.getBarrioZona())){
      listaErrores.put("El barrio no existe", false);
    }
  }
  
  private void jurisdiccion(BarrioZona barrio){
    if(Objects.isNull(barrio.getJurisdiccion())){
      listaErrores.put("Sin valor de jurisdiccion", false);
    }
  }

  /**
   * este metodo valida un id de barrio
   *
   * @param idBarrio el id a validar
   * @return un mapa de errores
   */
  public HashMap<Boolean, HashMap> validarBarrioZona(Integer idBarrio) {

    HashMap<Boolean, HashMap> errores = new HashMap<>();
    idValido(idBarrio);
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);
    } else {
      errores.put(true, listaErrores);
    }

    return errores;
  }

  /**
   * verifica que un id de barrio no sea nulo,negativo o que no exista
   *
   * @param idBarrio
   */
  private void idValido(Integer idBarrio) {
    if (Objects.isNull(idBarrio)) {
      listaErrores.put("Id nulo", false);
    } else  if (idBarrio <= 0) {
        listaErrores.put("Id menor o igual a 0", false);
      } else  if (!repositorioBarrioZona.existsById(idBarrio)){
          listaErrores.put("El Id de barrio no existe", false);
        }
      }
    }
  

