package com.SIREB.controladores;

import com.SIREB.modelos.Grado;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioGrado;
import com.SIREB.servicios.ServicioSesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Esta clase proporciona todos los endpoints necesarios para acceder a los
 * grados jerarquicos de los bomberos
 *
 * @author Marcelo Llanes
 */
@Controller
@RequestMapping("/grados")
public class ControladorGrado {

  @Autowired
  private ServicioGrado servicioGrado;

  /**
   * este metodo devuelve una coleccion con todos los grados contenidos en la db
   *
   * @param token token de sesion
   * @return una coleccion con los grados de los bomberos
   */
  @GetMapping("/mostrarGrados")
  public ResponseEntity<List<Grado>> mostrarGrados(@ModelAttribute Token token) {
    return servicioGrado.mostrarTodos(token.getLlave());
  }

  @GetMapping("/mostrar/{id}")
  public ResponseEntity<Grado> mostrarGrado(@PathVariable(name = "id") final Integer idgrado, @ModelAttribute Token token) {
    return servicioGrado.obtenerGrado(idgrado,token.getLlave());
  }
  /**
   * permite guardar un grado en la DB
   *
   * @param grado el grado a guardar
   * @return el grado eliminado
   */
  @PostMapping("/guardarGrado")
  public ResponseEntity guardarGrado(@RequestBody final Grado grado,@ModelAttribute Token token) {
    return servicioGrado.guardarGrado(grado,token.getLlave());
  }

  @PutMapping("/actualizarGrado")
  public ResponseEntity actualizarGrado(@RequestBody final Grado grado,@ModelAttribute Token token) {
    return servicioGrado.guardarGrado(grado,token.getLlave());
  }


  /**
   * permite eliminar un grado si existe
   * @param grado
   * @return responseEntity
   */
  @PostMapping("/eliminarGrado")
  public ResponseEntity eliminarGrado(@RequestBody final Grado grado,@ModelAttribute Token token){
    return servicioGrado.eliminarGrado(grado,token.getLlave());
  }
  @DeleteMapping("eliminarGrado/{id}")
  public ResponseEntity eliminarGrado(@PathVariable(name = "id") final Integer idgrado,@ModelAttribute Token token){
    return servicioGrado.eliminarGrado(idgrado, token.getLlave());
  }

}
