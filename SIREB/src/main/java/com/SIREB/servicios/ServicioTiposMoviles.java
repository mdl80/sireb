package com.SIREB.servicios;

import com.SIREB.modelos.RespuestaAccion;
import com.SIREB.modelos.TipoMovil;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioTipoMovil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.SIREB.repositorios.RepositorioTipoMovil;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wanda
 */

@Service
public class ServicioTiposMoviles {
    
    @Autowired
     private RepositorioTipoMovil repositorioTiposMoviles;
    
    //@Autowired
    //private ServicioRespuestaAccion respuestaServicio;
    
    @Autowired
    private ServicioEventos servicioEventos;
    
    @Autowired
    private ServicioSesion sesionServicio;
    
    
    public ResponseEntity guardarTiposMoviles(TipoMovil tiposMoviles, String llave){
     HashMap<Boolean, HashMap> listaErrores = new HashMap<>();
     HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
     RespuestaAccion respuesta = new RespuestaAccion();
     
     respuesta.setFecha(new Date());
     respuesta.setModulo(tiposMoviles.getClass().getSimpleName());
     respuesta.setTipo(Accion.AGREGAR.getActual());
     respuesta.setMapaErrores("");
     
     try{
      if (sesionServicio.Validar(llave)){
        //guardo el tipomovil y guardo lo devuelto en nuevoTipoMovil
        TipoMovil nuevoTipoMovil = repositorioTiposMoviles.save(tiposMoviles);
        
        if (nuevoTipoMovil.getIdTipoMovil() != null) {
          //genero la respuesta para el controlador y guardo el evento
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.AGREGAR, tiposMoviles));
          respuesta.setResultado(true);
          estado = HttpStatus.OK;
         } else {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.setResultado(false);
        }
     }
    } catch (Exception e) {

    }
      return new ResponseEntity(respuesta, estado);
   }
    
    public ResponseEntity actualizarTiposMoviles(TipoMovil tiposMoviles,Integer idTipoMovil, String llave) {
    HashMap<Boolean, HashMap> listaErrores = new HashMap<>();
    HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
    RespuestaAccion respuesta = new RespuestaAccion();
     
     respuesta.setFecha(new Date());
     respuesta.setModulo(tiposMoviles.getClass().getSimpleName());
     respuesta.setTipo(Accion.ACTUALIZAR.getActual());
     respuesta.setMapaErrores("");
    try {
      if (sesionServicio.Validar(llave)) {
        TipoMovil tipoMovilesDb = repositorioTiposMoviles.findById(idTipoMovil).get();
        //si lo que mando es distinto a lo que esta , actualizo
        if (!(tipoMovilesDb.equals(tipoMovilesDb))) {
          tipoMovilesDb.setTipo(tiposMoviles.getTipo());
          tipoMovilesDb.setDescripcion(tiposMoviles.getDescripcion());
          servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.ACTUALIZAR, tiposMoviles));
          respuesta.setResultado(true);
          estado = HttpStatus.OK;
        } else {
          estado = HttpStatus.INTERNAL_SERVER_ERROR;
          respuesta.setResultado(false);
        }
      }
    } catch (Exception e) {
      return null;
    }
     return new ResponseEntity(respuesta, estado);
  }
    
    public ResponseEntity eliminarTiposMoviles(TipoMovil tiposMoviles, String llave) {
     HashMap<Boolean, HashMap> listaErrores = new HashMap<>();
     HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
     RespuestaAccion respuesta = new RespuestaAccion();
     
     respuesta.setFecha(new Date());
     respuesta.setModulo(tiposMoviles.getClass().getSimpleName());
     respuesta.setTipo(Accion.ELIMINAR.getActual());
     respuesta.setMapaErrores("");
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nuevoEvento(llave, Accion.ELIMINAR, tiposMoviles));
        Integer idTipoMovil = tiposMoviles.getIdTipoMovil();
        repositorioTiposMoviles.delete(tiposMoviles);
        //si no esta en la base de datos entonces se elimino
        if(!repositorioTiposMoviles.existsById(idTipoMovil)){
         servicioEventos.agregarEvento(servicioEventos.nuevoEvento("Eliminar", Accion.ELIMINAR, tiposMoviles));
         respuesta.setResultado(true);
         estado = HttpStatus.OK;
        //el tipomovil no se elimino
        }else{
         respuesta.setResultado(false);
         estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
      }
    } catch (Exception e) {
      return null;
    }
    return new ResponseEntity(respuesta,estado);
  }
    
    
    public ResponseEntity<List<TipoMovil>> mostrarTodos(String llave) {
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nvoEventoListado(llave, "TiposMoviles"));
    }
      //si la llave no esta validada devuelve un httpstatus 412 (se puede mejorar)
      return new ResponseEntity("Error en token", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    } catch (Exception e) {
      return null;
    }
  }
    
    
    public ResponseEntity<TipoMovil> buscarPorTipoMovil(String tipo, String llave) {
    try {
      if (sesionServicio.Validar(llave)) {
        servicioEventos.agregarEvento(servicioEventos.nvoEventoListado(llave, "TiposMoviles"));
        return new ResponseEntity(repositorioTiposMoviles.findTipoMovilByTipo(tipo), HttpStatus.OK);
      }
      //si la llave no esta validada devuelve un httpstatus 412
      return new ResponseEntity("Error en token", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    } catch (Exception e) {
      return null;
    }
  }
}
