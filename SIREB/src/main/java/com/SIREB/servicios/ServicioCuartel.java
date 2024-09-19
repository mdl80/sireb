package com.SIREB.servicios;

import com.SIREB.modelos.Cuartel;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioCuartel;
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorCuartel;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fer Guzman
 */
@Service
@Slf4j

public class ServicioCuartel {
   @Autowired 
   private RepositorioCuartel repositorioCuartel;
   
  @Autowired
  private ServicioSesion sesionServicio;

  private ServicioRespuestaAccion respuesta;
  @Autowired
  private ValidadorCuartel validadorCuartel;
  @Autowired
  private ServicioEventos eventoServicio;
  
   public ResponseEntity buscarPorId(Integer idCuartel, String llave) {
   respuesta = new ServicioRespuestaAccion();
      // return repositorioCuartel.findById(idCuartel).orElse(null);
    HashMap<Boolean, HashMap> mapaErrores = new HashMap<>();
    HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;

    try {
      if (sesionServicio.Validar(llave)) {
        estado = HttpStatus.OK;
        eventoServicio.agregarEvento(eventoServicio.nvoEventoListado(llave, "Cuartel"));
        return new ResponseEntity(repositorioCuartel.findById(idCuartel), estado);
      } else {
        respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, mapaErrores);

      }
    } catch (Exception e) {
      //todavia nada
    }
    return new ResponseEntity(respuesta.devolverRespuesta(), estado);
   
   
   }

 public ResponseEntity guardarCuartel(Cuartel cuartel, String llave) {
   respuesta = new ServicioRespuestaAccion();
     HttpStatus estado = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
     HashMap<Boolean, HashMap> mapaErrores = new HashMap<>();
     try {
         if (sesionServicio.Validar(llave)) {
           Cambiador.paseMayuscula(cuartel);
             repositorioCuartel.save(cuartel);
             estado = HttpStatus.OK;
             respuesta.crearRespuestaAccion(Cuartel.class, Accion.GUARDAR, true, mapaErrores);
         } else {
             mapaErrores.clear();
             respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, mapaErrores);
         }
     } catch (Exception e) {
     }
     return new ResponseEntity(respuesta.devolverRespuesta(), estado);
 }     
}
