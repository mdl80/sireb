package com.SIREB.servicios;

import com.SIREB.modelos.Grado;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioGrado;
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorGrado;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona todos los servicios necesarios para el CRUD de grados
 *
 * @author Marcelo Llanes
 */
@Service
@Slf4j
public class ServicioGrado {

  @Autowired
  private RepositorioGrado repositorioGrados;
  @Autowired
  private ServicioSesion sesionServicio;
  private ServicioRespuestaAccion respuesta;
  private ValidadorGrado validadorGrado;
  @Autowired
  private ServicioEventos eventoServicio;

  /**
   * A traves de este metodo se guardan los grados, el grado se guarda si no
   * existe
   *
   * @param grado el grado a guardar
   * @return ResponseEntity CREATED guardado, si el grado ha sido guardado,
   * ResponseEntity PRECONDITION_FAILED si el grado no ha sido guardado
   */
  public ResponseEntity guardarGrado(Grado grado, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validadorGrado = new ValidadorGrado(repositorioGrados);
    HashMap<Boolean, HashMap> mapaErrores = validadorGrado.validarGrado(grado);
    HttpStatus estado = HttpStatus.OK;
    try {
        if(sesionServicio.Validar(llave) && mapaErrores.containsKey(true)){
          Cambiador.paseMayuscula(grado);
          repositorioGrados.save(grado);
          if(repositorioGrados.existsGradoByGrado(grado.getGrado())){
            eventoServicio.agregarEvento(eventoServicio.nuevoEvento(llave, Accion.AGREGAR, grado));
            respuesta.crearRespuestaAccion(Grado.class, Accion.AGREGAR, true, mapaErrores);
          }else{
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
            respuesta.crearRespuestaAccion(Grado.class, Accion.AGREGAR, false, mapaErrores);
          }
        }
        if(sesionServicio.Validar(llave) && mapaErrores.containsKey(false)){
          estado = HttpStatus.PRECONDITION_FAILED;
          respuesta.crearRespuestaAccion(Grado.class, Accion.AGREGAR, false, mapaErrores);
        }
        if(!sesionServicio.Validar(llave)){
          respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
        }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * este metodo devuelve un grado a partir de un id de grado
   *
   * @param idGrado
   * @return
   */
  public ResponseEntity<Grado> obtenerGrado(int idGrado, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validadorGrado = new ValidadorGrado(repositorioGrados);
    HashMap<Boolean, HashMap> mapaErrores = validadorGrado.validarGrado(idGrado);
    HttpStatus estado = HttpStatus.OK;
    try {
      if(!sesionServicio.Validar(llave)){
          respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
        }
      if(sesionServicio.Validar(llave) && mapaErrores.containsKey(true)){
        return new ResponseEntity(repositorioGrados.findById(idGrado).get(),estado);
      }
      if(sesionServicio.Validar(llave) && mapaErrores.containsKey(false)){
        estado = HttpStatus.PRECONDITION_FAILED;
        respuesta.crearRespuestaAccion(Grado.class, Accion.AGREGAR, false, mapaErrores);
      }
    } catch (Exception e) {
      //todavia nada
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
      

  }

  /**
   * muestra todos los grados disponibles
   *
   * @return una coleccion de grados disponibles
   */
  public ResponseEntity mostrarTodos(String llave) {
    respuesta = new ServicioRespuestaAccion();
    HttpStatus estado = HttpStatus.OK;
    try {
      if (sesionServicio.Validar(llave)) {
        eventoServicio.agregarEvento(eventoServicio.nvoEventoListado(llave, "Grados"));
        return new ResponseEntity(repositorioGrados.findAll(), estado);
      } else {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      //todavia nada
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  
  /**
   * elimina un grado de la db
   *
   * @param grado el grado a eliminar
   * @param llave el token de usuario
   * @return responseentity
   */
  public ResponseEntity eliminarGrado(Grado grado, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validadorGrado = new ValidadorGrado(repositorioGrados);
    HashMap<Boolean, HashMap> mapaErrores = validadorGrado.validarGrado(grado);
    HttpStatus estado = HttpStatus.OK;
    try {
      if(!sesionServicio.Validar(llave)){
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if(sesionServicio.Validar(llave) && mapaErrores.containsKey(false)){
        respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, false, mapaErrores);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
      if(sesionServicio.Validar(llave) && repositorioGrados.existsGradoByGrado(grado.getGrado())){
        repositorioGrados.delete(grado);
        if(repositorioGrados.existsGradoByGrado(grado.getGrado())){
          respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, false, mapaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }else{
          respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, true, null);
        }
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(),estado);
  }
  
  /**
   * elimina un grado de la db
   *
   * @param idGrado el id de grado a eliminar
   * @param llave el token de usuario
   * @return responseentity
   */
  public ResponseEntity eliminarGrado(Integer idGrado, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validadorGrado = new ValidadorGrado(repositorioGrados);
    HashMap<Boolean, HashMap> mapaErrores = validadorGrado.validarGrado(idGrado);
    HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
    try {
      if(!sesionServicio.Validar(llave)){
        mapaErrores.clear();
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, mapaErrores);
      }
      if(sesionServicio.Validar(llave) && mapaErrores.containsKey(false)){
        respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, false, mapaErrores);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
      if(sesionServicio.Validar(llave) && repositorioGrados.existsById(idGrado)){
        repositorioGrados.deleteById(idGrado);
        if(repositorioGrados.existsById(idGrado)){
          respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, false, mapaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }else{
          respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, true, mapaErrores);
          estado = HttpStatus.OK;
        }
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(),estado);
  }

}
