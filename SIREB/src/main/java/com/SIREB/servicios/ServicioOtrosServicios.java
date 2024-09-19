package com.SIREB.servicios;

import com.SIREB.validadores.Cambiador;
import com.SIREB.modelos.OtrosServicios;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioOtrosServicios;
import com.SIREB.validadores.ValidadorOtrosServicios;
import java.util.HashMap;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Llanes
 */
@Service
public class ServicioOtrosServicios {

  @Autowired
  private RepositorioOtrosServicios repositorio;
  private ServicioRespuestaAccion respuesta;
  @Autowired
  private ServicioSesion sesion;
  @Autowired
  private ServicioEventos evento;

  /**
   * A traves de este metodo se guardan los grados, el grado se guarda si no
   * existe
   *
   * @param servicio el servicio a guardar
   * @param llave token de usuario
   * @return ResponseEntity CREATED guardado, si el servicio ha sido guardado,
   * ResponseEntity PRECONDITION_FAILED si el servicio no ha sido guardado
   */
  public ResponseEntity guardarServicio(OtrosServicios servicio, String llave) {
    respuesta = new ServicioRespuestaAccion();
    ValidadorOtrosServicios validador = new ValidadorOtrosServicios(repositorio);
    HashMap<Boolean, HashMap> mapaErrores = validador.validarServicio(servicio, Accion.AGREGAR);
    boolean servicioValidado = mapaErrores.containsKey(true);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (!sesion.Validar(llave)) {
        mapaErrores.clear();
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if (sesion.Validar(llave) && servicioValidado) {
        Cambiador.paseMayuscula(servicio);
        repositorio.save(servicio);
        if (repositorio.existsOtrosServiciosByServicio(servicio.getServicio())) {
          respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.GUARDAR, true, mapaErrores);
          evento.agregarEvento(evento.nuevoEvento(llave, Accion.GUARDAR, servicio));
        } else {
          respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.GUARDAR, false, mapaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
      }
      if (sesion.Validar(llave) && !servicioValidado) {
        respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.GUARDAR, false, mapaErrores);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity actualizarServicio(OtrosServicios servicio, Integer idServicio, String llave) {
    respuesta = new ServicioRespuestaAccion();
    ValidadorOtrosServicios validador = new ValidadorOtrosServicios(repositorio);
    HashMap<Boolean, HashMap> erroresServicio = validador.validarServicio(servicio, Accion.ACTUALIZAR);
    HashMap<Boolean, HashMap> erroresIdServicio = validador.validarServicio(idServicio);
    boolean idServicioValidado = validador.validarServicio(idServicio).containsKey(true);
    boolean servicioValidado = validador.validarServicio(servicio, Accion.ACTUALIZAR).containsKey(true);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (!sesion.Validar(llave)) {
        erroresServicio.clear();
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if (sesion.Validar(llave) && servicioValidado && idServicioValidado) {
        Cambiador.paseMayuscula(servicio);
        repositorio.save(servicio);
        //si son iguales se actualizo
        if (Objects.equals(repositorio.findById(idServicio), servicio)) {
          respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ACTUALIZAR, true, null);
          evento.agregarEvento(evento.nuevoEvento(llave, Accion.ACTUALIZAR, servicio));
        } else {
          respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ACTUALIZAR, false, erroresServicio);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
      }
      if (sesion.Validar(llave) && idServicioValidado && !servicioValidado) {
        respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ACTUALIZAR, false, erroresServicio);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
      if (sesion.Validar(llave) && !idServicioValidado && servicioValidado) {
        respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ACTUALIZAR, false, erroresIdServicio);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);

  }

  /**
   * este metodo devuelve un Servicio a partir de un id de OtrosServicios
   *
   * @param idServicio el id de servicio
   * @param llave token de usuario
   * @return el servicio correspondiente al Id de servicio
   */
  public ResponseEntity<OtrosServicios> obtenerServicio(int idServicio, String llave) {
    respuesta = new ServicioRespuestaAccion();
    ValidadorOtrosServicios validador = new ValidadorOtrosServicios(repositorio);
    HashMap<Boolean, HashMap> mapaErrores = validador.validarServicio(idServicio);
    boolean gradoValidado = mapaErrores.containsKey(true);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (!sesion.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if (sesion.Validar(llave) && gradoValidado) {
        return new ResponseEntity(repositorio.findById(idServicio), estado);
      }
      if (sesion.Validar(llave) && !gradoValidado) {
        estado = HttpStatus.PRECONDITION_FAILED;
        respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.MOSTRAR, false, mapaErrores);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * muestra todos los servicios disponibles
   *
   * @return una coleccion de grados disponibles
   */
  public ResponseEntity mostrarTodos(String llave) {
    respuesta = new ServicioRespuestaAccion();
    HttpStatus estado = HttpStatus.OK;

    try {
      if (sesion.Validar(llave)) {
        evento.agregarEvento(evento.nvoEventoListado(llave, "Otros Servicios"));
        return new ResponseEntity(repositorio.findAll(), estado);
      } else {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      //todavia nada
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * elimina un servicio de la db
   *
   * @param idServicio el id del servicio a eliminar
   * @return responseentity
   */
  public ResponseEntity eliminarServicio(Integer idServicio, String llave) {
    respuesta = new ServicioRespuestaAccion();
    ValidadorOtrosServicios validador = new ValidadorOtrosServicios(repositorio);
    HashMap<Boolean, HashMap> mapaErrores = validador.validarServicio(idServicio);
    boolean servicioValidado = mapaErrores.containsKey(true);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (!sesion.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if (sesion.Validar(llave) && servicioValidado) {
        OtrosServicios deletedServicio = repositorio.findById(idServicio).get();
        repositorio.deleteById(idServicio);
        //controlo si se elimino el servicio 
        if (repositorio.existsOtrosServiciosByServicio(deletedServicio.getServicio())) {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ELIMINAR, false, mapaErrores);
        } else {
          evento.agregarEvento(evento.nuevoEvento(llave, Accion.ELIMINAR, idServicio));
          respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ELIMINAR, true, null);
        }
      }
      if (sesion.Validar(llave) && !servicioValidado) {
        estado = HttpStatus.PRECONDITION_FAILED;
        respuesta.crearRespuestaAccion(OtrosServicios.class, Accion.ELIMINAR, false, mapaErrores);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }
}
