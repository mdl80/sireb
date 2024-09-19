package com.SIREB.servicios;

import com.SIREB.modelos.Movil;
import com.SIREB.modelos.RespuestaAccion;
import com.SIREB.modelos.enums.Accion;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.SIREB.repositorios.RepositorioMovil;
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorMovil;
import org.apache.coyote.http11.Http11AprProtocol;

/**
 *
 * @author Wanda
 */
@Slf4j
@Service
public class ServicioMovil {

  @Autowired
  private RepositorioMovil repositorio;
  private ServicioRespuestaAccion respuesta;
  @Autowired
  private ServicioEventos servicioEventos;
  @Autowired
  private ServicioSesion sesionServicio;
  private ValidadorMovil validador;

  public ResponseEntity guardarMovil(Movil movil, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorMovil(repositorio);
    HttpStatus estado = HttpStatus.OK;
    HashMap<Boolean, HashMap> listaErrores = validador.validarMovil(movil);
    try {
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true)) {
        Cambiador.paseMayuscula(movil);
        repositorio.save(movil);
        if (repositorio.existsByNumeroMovil(movil.getNumeroMovil())) {
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.AGREGAR, movil));
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, true, null);
        } else {
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, false, listaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, false, listaErrores);
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity actualizarMoviles(Movil movil, Integer idMovil, String llave) {
    validador = new ValidadorMovil(repositorio);
    HashMap<Boolean, HashMap> listaErrores = validador.validarMovil(movil);
    HttpStatus estado = HttpStatus.OK;
    respuesta = new ServicioRespuestaAccion();
    try {
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true)) {
        Movil movilDb = repositorio.findById(idMovil).get();
        movil.setIdMovil(idMovil);
        repositorio.save(movil);
        if (movil.equals(movilDb)) {
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.ACTUALIZAR, movil));
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, true, listaErrores);
        } else {
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, false, listaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.AGREGAR, false, listaErrores);
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
      return null;
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity eliminarMoviles(int idMovil, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorMovil(repositorio);
    HashMap<Boolean, HashMap> listaErrores = validador.validarIdMovil(idMovil);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true)) {
        Movil movil = repositorio.findById(idMovil).get();
        repositorio.deleteById(idMovil);
        if (repositorio.existsById(idMovil)) {
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.ELIMINAR, false, listaErrores);
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
          respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.ELIMINAR, true, listaErrores);
          servicioEventos.nuevoEvento(llave, Accion.ELIMINAR, movil);
        }
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.ELIMINAR, false, listaErrores);
        log.info(respuesta.devolverRespuesta().toString());
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }

    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity<List<Movil>> mostrarTodos(String llave) {
    respuesta = new ServicioRespuestaAccion();
    boolean permiso = true;
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nvoEventoListado(llave, "Moviles"));
        return new ResponseEntity(repositorio.findAll(), HttpStatus.OK);
      } else {
        respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.MOSTRAR, false, null);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
  }

  public ResponseEntity<Movil> buscarPornumeroMovil(int idMovil, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorMovil(repositorio);
    HttpStatus estado = HttpStatus.OK;
    HashMap<Boolean, HashMap> listaErrores = validador.validarIdMovil(idMovil);
    try {
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true)) {
        return new ResponseEntity(repositorio.findById(idMovil).get(), estado);
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(ServicioMovil.class, Accion.MOSTRAR, false, listaErrores);
      }
      if(!sesionServicio.Validar(llave)){
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }
}
