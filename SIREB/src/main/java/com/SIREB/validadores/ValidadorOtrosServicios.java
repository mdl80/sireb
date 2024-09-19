package com.SIREB.validadores;

import com.SIREB.modelos.OtrosServicios;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioOtrosServicios;
import java.util.HashMap;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * esta clase se encarga de validar OtrosServicios
 *
 * @author Marcelo Llanes
 */
public class ValidadorOtrosServicios {

  private HashMap<Boolean, HashMap> errores = new HashMap<>();
  private HashMap<String, Boolean> listaErrores = new HashMap<>();
  @Autowired
  private RepositorioOtrosServicios repositorio;

  public ValidadorOtrosServicios(RepositorioOtrosServicios repositorio) {
    this.repositorio = repositorio;
  }

  /**
   * Esta metodo valida un Servicio del Repositorio, las comprobaciones que
   * realiza son nombre nulo, nombre vacio o en blanco y que no se incluyan
   * caracteres especiales o numeros, y que el dato a validar sea del tipo
   * OtrosServicios
   *
   * @param servicio el servicio a validar
   * @param accion Agregar para validar un grado que debe guardarse, Eliminar
   * para un grado que se debe eliminar
   * @return un mapa de true, null si el gradoRepositorio es validado, un mapa
   * false,hashmap si el gradoRepositorio no es validado, el mapa devuelto
   * contiene todos los errores detectados
   * <Boolean, mapa de errores>
   */
  public HashMap<Boolean, HashMap> validarServicio(OtrosServicios servicio, Accion accion) {
    noNuloServicio(servicio);
    //si es nulo o no es la clase esperada no se deben ejecutar las otras comprobaciones
    if (listaErrores.containsKey("Servicio nulo")
      || listaErrores.containsKey("El servicio no es de tipo OtrosServicios")) {
      errores.put(false, listaErrores);
      return errores;
    } else {

      if (accion.equals(accion.AGREGAR)) {
        existeGuardarServicio(servicio);
        descripcionVacia(servicio);
        nombreServicio(servicio);
        caracterServicio(servicio);
        longitudServicio(servicio);
      }
      if (accion.equals(accion.ELIMINAR)) {
        existeEliminarServicio(servicio);
        descripcionVacia(servicio);
        nombreServicio(servicio);
        caracterServicio(servicio);
        longitudServicio(servicio);
      }
      if (accion.equals(accion.ACTUALIZAR)) {
        descripcionVacia(servicio);
        nombreServicio(servicio);
        caracterServicio(servicio);
        longitudServicio(servicio);
      }
    }
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);

    } else {
      errores.put(true, listaErrores);

    }
    return errores;
  }

  /**
   * este metodo valida que el nombre del servicio no sea en blanco o de
   * longitud 0 si no es validado se lo agrega a un mapa de errores
   *
   * @param servicio el servicio a validar
   */
  private void nombreServicio(OtrosServicios servicio) {
    if (servicio.getServicio().isEmpty() || servicio.getServicio().isBlank() || Objects.isNull(servicio.getServicio())) {
      listaErrores.put("Servicio en blanco", false);
    }

  }

  /**
   * este metodo valida que el nombre no incluya numeros o caracteres especiales
   * si no cumple la condicion lo agrega a un mapa de errores
   *
   * @param grado el gradoRepositorio a validar
   */
  private void caracterServicio(OtrosServicios servicio) {
    if (!servicio.getServicio().matches("^[a-zA-ZñÑ]+$")) {
      listaErrores.put("Caracteres invalidos utilizados", false);
    }
  }

  /**
   * este metodo valida que el servicio a validar sea de la clase esperada y que
   * no sea nulo, si no cumple la condicion de validacion se agrega a un mapa de
   * errores
   *
   * @param servicio el servicio a validar
   */
  private void noNuloServicio(OtrosServicios servicio) {
    if (Objects.isNull(servicio)) {
      listaErrores.put("Servicio nulo", false);
    } else {
      if (!servicio.getClass().equals(OtrosServicios.class)) {
        listaErrores.put("El servicio no es de tipo OtrosServicios", false);
      }
    }
  }

  /**
   * este metodovalida la longitud del nombre del servicio, si no cumple con la
   * validacion es agregado a un mapa de errores;
   *
   * @param servicio el grado a verificar
   */
  private void longitudServicio(OtrosServicios servicio) {
    if (servicio.getServicio().length() < 4) {
      listaErrores.put("Nombre de servicio corto", false);
    }
  }

  /**
   * este metodo es parte del metodo validarOtrosServicio, verifica que el
   * servicio a guardar no exista en la base de datos
   *
   * @param servicio el grado a verificar
   */
  private void existeGuardarServicio(OtrosServicios servicio) {
    if (repositorio.existsOtrosServiciosByServicio(servicio.getServicio())) {
      listaErrores.put("El servicio ya existe", false);
    }
  }

  private void descripcionVacia(OtrosServicios servicio) {
    if (Objects.isNull(servicio.getDescripcion())) {
      servicio.setDescripcion("");
    }
  }

  /**
   * este metodo es usado por el metodo publico validarOtrosServicios verifica
   * que el grado a eliminar exista en la base de datos
   *
   * @param servicio el servicio a verificar
   */
  private void existeEliminarServicio(OtrosServicios servicio) {
    if (!repositorio.existsOtrosServiciosByServicio(servicio.getServicio())) {
      listaErrores.put("El servicio no existe", false);
    }
  }

  /**
   * este metodo valida un servicio de la db a traves de un id
   *
   * @param idServicio el id a validar
   * @return un mapa de errores
   */
  public HashMap<Boolean, HashMap> validarServicio(Integer idServicio) {
    idValido(idServicio);
    if (listaErrores.containsValue(false)) {
      errores.put(false, listaErrores);
    } else {
      errores.put(true, listaErrores);
    }
    return errores;
  }

  /**
   * verifica que un id ingresado no sea nulo o negativo
   *
   * @param idServicio el id a verificar
   */
  private void idValido(Integer idServicio) {
    if (Objects.isNull(idServicio)) {
      listaErrores.put("Id nulo", false);
    } else if (idServicio <= 0) {
      listaErrores.put("Id menor o igual a 0", false);
    } else if (!repositorio.existsById(idServicio)) {
      listaErrores.put("El Id de grado no existe", false);
    }
  }
}
