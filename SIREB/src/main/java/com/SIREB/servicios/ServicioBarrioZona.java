package com.SIREB.servicios;

import com.SIREB.modelos.BarrioZona;
import com.SIREB.modelos.Grado;
import com.SIREB.modelos.enums.Accion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorBarrioZona;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author kike
 */
@Service
@Slf4j

public class ServicioBarrioZona {

  @Autowired
  private RepositorioBarrioZona repositorioBarrio;

  @Autowired
  private ServicioEventos eventoServicio;

  @Autowired
  private ServicioSesion sesionServicio;

  private ServicioRespuestaAccion respuesta;

  private ValidadorBarrioZona validador;

  public BarrioZona buscarPorId(Integer idBarrioZona) {

    return repositorioBarrio.findById(idBarrioZona).orElse(null);
  }

  public ResponseEntity agregarBarrioZona(BarrioZona barrioZona, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorBarrioZona(repositorioBarrio);
    HashMap<Boolean, HashMap> listaErrores = validador.validarBarrioZona(barrioZona, Accion.AGREGAR);
    HttpStatus estado = HttpStatus.OK;
    try {
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true)) {
        Cambiador.paseMayuscula(barrioZona);
        BarrioZona nvoBarrioZona = repositorioBarrio.save(barrioZona);
        if (nvoBarrioZona.getIdBarrioZona() != null) {
          eventoServicio.agregarEvento(eventoServicio.nuevoEvento(llave, Accion.AGREGAR, barrioZona));
          respuesta.crearRespuestaAccion(BarrioZona.class, Accion.AGREGAR, true, listaErrores);
        } else {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.crearRespuestaAccion(BarrioZona.class, Accion.AGREGAR, false, listaErrores);
        }
      } else if (sesionServicio.Validar(llave) && listaErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(BarrioZona.class, Accion.AGREGAR, false, listaErrores);
      }
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity<List<BarrioZona>> mostrarTodos(String llave) {
    respuesta = new ServicioRespuestaAccion();
    HttpStatus estado = HttpStatus.OK;
    try {
      if (sesionServicio.Validar(llave)) {
        eventoServicio.agregarEvento(eventoServicio.nvoEventoListado(llave, "Grados"));
        return new ResponseEntity(repositorioBarrio.findAll(), estado);
      } else {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {

    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
  }

  public ResponseEntity eliminarBarrioZona(Integer id, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorBarrioZona(repositorioBarrio);
    HashMap<Boolean, HashMap> listaErrores = validador.validarBarrioZona(id);
    HttpStatus estado = HttpStatus.OK;
    try {
      if(sesionServicio.Validar(llave) && listaErrores.containsKey(false)){
        respuesta.crearRespuestaAccion(BarrioZona.class, Accion.ELIMINAR, false, listaErrores);
      }
      if(sesionServicio.Validar(llave) && listaErrores.containsKey(true)){
        repositorioBarrio.delete(repositorioBarrio.findById(id).get());     
      }if(repositorioBarrio.existsById(id)){
        estado = HttpStatus.INTERNAL_SERVER_ERROR;
        respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, false, listaErrores);
      }else{
        respuesta.crearRespuestaAccion(Grado.class, Accion.ELIMINAR, true, listaErrores);
      }
      if(!sesionServicio.Validar(llave)){
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(),estado);
  }

  public ResponseEntity actualizarBarrioZona(BarrioZona barrioZona, int idBarrioZona, String llave) {
    respuesta = new ServicioRespuestaAccion();
    validador = new ValidadorBarrioZona(repositorioBarrio);
    HashMap<Boolean, HashMap> listaErrores = validador.validarBarrioZona(barrioZona, Accion.ACTUALIZAR);
    HashMap<Boolean, HashMap> idErrores = validador.validarBarrioZona(idBarrioZona);
    HttpStatus estado = HttpStatus.OK;

    try {
      if (!sesionServicio.Validar(llave)) {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true) && idErrores.containsKey(true)) {
        Cambiador.paseMayuscula(barrioZona);
        BarrioZona barrioZonaDb = repositorioBarrio.findById(idBarrioZona).get();
        //si lo que mando es distinto a lo que esta , actualizo
        if (!barrioZona.equals(barrioZonaDb)) {
          barrioZonaDb.setBarrioZona(barrioZona.getBarrioZona());
          barrioZonaDb.setJurisdiccion(barrioZona.getJurisdiccion());
          repositorioBarrio.save(barrioZonaDb);
          eventoServicio.agregarEvento(eventoServicio.nuevoEvento(llave, Accion.ACTUALIZAR, barrioZona));
          respuesta.crearRespuestaAccion(BarrioZona.class, Accion.ACTUALIZAR, true, listaErrores);
        }
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(true) && idErrores.containsKey(false)) {
        respuesta.crearRespuestaAccion(BarrioZona.class, Accion.ACTUALIZAR, false, idErrores);
        estado = HttpStatus.PRECONDITION_FAILED;

      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false) && idErrores.containsKey(true)) {
        respuesta.crearRespuestaAccion(BarrioZona.class,
          Accion.ACTUALIZAR, false, listaErrores);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
      if (sesionServicio.Validar(llave) && listaErrores.containsKey(false) && idErrores.containsKey(false)) {
        HashMap<Boolean, String> errores = new HashMap();
        errores.put(false, "Error en barrio y en id");
        respuesta.crearRespuestaAccion(BarrioZona.class, Accion.ACTUALIZAR, false, errores);
        estado = HttpStatus.PRECONDITION_FAILED;
      }
    } catch (Exception e) {
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);

  }

}
