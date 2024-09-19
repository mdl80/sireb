package com.SIREB.servicios;

import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioCuartel;
import com.SIREB.repositorios.RepositorioGrado;
import com.SIREB.repositorios.RepositorioMotivoBaja;
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorBombero;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * esta clase Proporciona los servicios necesarios a los EndPoints relacionados
 * a Bomberos
 */
@Slf4j
@Service
public class ServicioBombero {

  @Autowired
  private RepositorioCuartel repositorioCuartel;
  @Autowired
  private RepositorioGrado repositorioGrado;
  @Autowired
  private RepositorioMotivoBaja repositorioBaja;
  @Autowired
  private RepositorioBombero repositorioBombero;
  @Autowired
  private ServicioEventos servicioEventos;
  @Autowired
  private ServicioSesion sesionServicio;
  private ValidadorBombero validadorBombero;
  private ServicioRespuestaAccion respuesta;

  /**
   * Guarda el bombero ingresado en la db
   *
   * @param bombero el bombero a guardar
   * @param llave token de usuario
   */
  public ResponseEntity guardarBombero(Bombero bombero, String llave) {
    respuesta = new ServicioRespuestaAccion();
    HttpStatus estado = HttpStatus.OK;
    validadorBombero = new ValidadorBombero(repositorioCuartel, repositorioGrado, repositorioBaja, repositorioBombero);
    HashMap<Boolean, HashMap> bomberoValidado = validadorBombero.validarBombero(bombero);
    try {
      if (sesionServicio.Validar(llave) && bomberoValidado.containsKey(true)) {
        Cambiador.paseMayuscula(bombero);
        repositorioBombero.save(bombero);
        if (repositorioBombero.existsByDNI(bombero.getDNI())) {
          servicioEventos.nuevoEvento(llave, Accion.AGREGAR, bombero);
          respuesta.crearRespuestaAccion(Bombero.class, Accion.AGREGAR, true, bomberoValidado);
        } else {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.crearRespuestaAccion(Bombero.class, Accion.AGREGAR, false, bomberoValidado);
        }
      }
      if (sesionServicio.Validar(llave) && bomberoValidado.containsKey(false)) {
        estado = HttpStatus.PRECONDITION_FAILED;
        respuesta.crearRespuestaAccion(Bombero.class, Accion.AGREGAR, false, bomberoValidado);
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * este metodo actualiza un bombero existente en la base de datos
   *
   * @param bombero el bombero con datos actualizados
   * @param idBombero el id del bombero a actualizar
   * @param llave token de sesion
   * @return ResponseEntity
   */
  public ResponseEntity actualizarBombero(Bombero bombero, int idBombero, String llave) {
    respuesta = new ServicioRespuestaAccion();
    HttpStatus estado = HttpStatus.OK;
    validadorBombero = new ValidadorBombero(repositorioCuartel, repositorioGrado, repositorioBaja, repositorioBombero);
    HashMap<Boolean, HashMap> bomberoValidado = validadorBombero.validarBombero(bombero, idBombero);
    try {
      if (sesionServicio.Validar(llave) && bomberoValidado.containsKey(true)) {
        Cambiador.paseMayuscula(bombero);
        Bombero bomberoDb = repositorioBombero.findById(idBombero).get();
        if (!bomberoDb.equals(bombero)) {
          bomberoDb.setDNI(bombero.getDNI());
          bomberoDb.setNombre1(bombero.getNombre1());
          bomberoDb.setNombre2(bombero.getNombre2());
          bomberoDb.setApellido(bombero.getApellido());
          bomberoDb.setTelefonoCasa(bombero.getTelefonoCasa());
          bomberoDb.setTelefonoCelular(bombero.getTelefonoCelular());
          bomberoDb.setDireccion(bombero.getDireccion());
          bomberoDb.setFechaNacimiento(bombero.getFechaNacimiento());
          bomberoDb.setEdad(bombero.getEdad());
          bomberoDb.setFactorSanguineo(bombero.getFactorSanguineo());
          bomberoDb.setGenero(bombero.getGenero());
          bomberoDb.setFechaAlta(bombero.getFechaAlta());
          bomberoDb.setFechaBaja(bombero.getFechaBaja());
          bomberoDb.setIdMotivoBaja(bombero.getIdMotivoBaja());
          bomberoDb.setIdGrado(bombero.getIdGrado());
          bomberoDb.setIdCuartel(bombero.getIdCuartel());
          repositorioBombero.save(bomberoDb);
        }
        if (bombero.equals(bomberoDb)) {
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.ACTUALIZAR, bombero));
          respuesta.crearRespuestaAccion(Bombero.class, Accion.ACTUALIZAR, true, bomberoValidado);
        } else {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.crearRespuestaAccion(Bombero.class, Accion.ACTUALIZAR, false, bomberoValidado);
        }
        
      }
      if (sesionServicio.Validar(llave) && bomberoValidado.containsKey(false)) {
        estado = HttpStatus.PRECONDITION_FAILED;
        respuesta.crearRespuestaAccion(Bombero.class, Accion.ACTUALIZAR, false, bomberoValidado);
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      return null;
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * este metodo elimina un bombero de la base de datos
   *
   * @param bombero el bombero a eliminar
   * @param llave token se sesion
   * @return ResponseEntity
   */
  public ResponseEntity eliminarBombero(String dni, String llave) {
    respuesta = new ServicioRespuestaAccion();
    ValidadorBombero validador = new ValidadorBombero(repositorioCuartel, repositorioGrado, repositorioBaja, repositorioBombero);
    HashMap<Boolean, HashMap> listaErrores = validador.validarBombero(dni);
    HttpStatus estado = HttpStatus.OK;
    try {
      if(sesionServicio.Validar(llave) && listaErrores.containsKey(false)){
        respuesta.crearRespuestaAccion(Bombero.class, Accion.ELIMINAR, false, listaErrores);
      }
      if(sesionServicio.Validar(llave) && listaErrores.containsKey(true)){
        Bombero bombero = repositorioBombero.buscarPorDNI(dni);
        repositorioBombero.delete(bombero);
        if(repositorioBombero.existsByDNI(dni)){
          respuesta.crearRespuestaAccion(Bombero.class, Accion.ELIMINAR, false, listaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }else{
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.ELIMINAR, bombero));
          respuesta.crearRespuestaAccion(Bombero.class, Accion.ELIMINAR, true, listaErrores);
        }
      }
      if(!sesionServicio.Validar(llave)){
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      log.info("entramos en excepcion");
      return null;
    }
    log.info("en el return valor de respuesta: " + respuesta.devolverRespuesta().toString());
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  /**
   * este metodo devuelve un listado de todos los bomberos activos
   *
   * @param llave token de sesion
   * @return responseEntity<List<Bomberos>>
   */
  public ResponseEntity<List<Bombero>> mostrarTodos(String llave) {
    respuesta = new ServicioRespuestaAccion();
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nvoEventoListado(llave, "Bomberos"));
        //se devuelve la lista de bomberos en un response entity
        return new ResponseEntity(repositorioBombero.BuscarBomberosActivos(), HttpStatus.OK);
      }
      respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
    } catch (Exception e) {
      
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
  }

  /**
   * este metodo devuelve un Bombero buscado por DNI
   *
   * @param dni dni del bombero a buscar
   * @param llave token de la sesion
   * @return Bombero
   */
  public ResponseEntity<Bombero> buscarPorDNI(String dni, String llave) {
    respuesta = new ServicioRespuestaAccion();
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nvoEventoListado(llave, "DNI"));
        return new ResponseEntity(repositorioBombero.buscarPorDNI(dni), HttpStatus.OK);
      }
      respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
    } catch (Exception e) {
      return null;
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
  }

  /**
   * metodo sobre cargado de buscarPorDni
   *
   * @param dni del bombero a buscar
   * @return el bombero on el dni ingresado
   */
  public Bombero buscarPorDNI(String dni) {
    try {
      return repositorioBombero.buscarPorDNI(dni);
    } catch (Exception e) {
      return null;
    }
  }
}
