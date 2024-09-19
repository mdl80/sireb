package com.SIREB.controladores;

import com.SIREB.modelos.Movil;
import com.SIREB.modelos.TipoMovil;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioMovil;
import com.SIREB.servicios.ServicioTiposMoviles;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wanda
 */
@Slf4j
@RestController
@RequestMapping("/moviles")
public class ControladorMovil {

  @Autowired
  private ServicioMovil servicioMoviles;
  
  @Autowired
  private ServicioTiposMoviles servicioTiposMoviles;

  // Endpoint para obtener una lista de moviles.
  /**
   * este endpoint permite obtener todos los moviles
   *
   * @return Una lista con todos los moviles
   */
  @GetMapping(value = "/mostrarMoviles")
  public ResponseEntity<List<Movil>> obtenerMoviles(@ModelAttribute Token token) {
    return servicioMoviles.mostrarTodos(token.getLlave());
  }

    
@PostMapping(value = "/guardarMoviles/")
  public ResponseEntity guardarMovil(@RequestBody final Movil movil, @ModelAttribute Token token) {
    return servicioMoviles.guardarMovil(movil, token.getLlave());
}
  
  /**
   * este metodo actualiza los datos de un movil
   *
   * @param id id del movil a actualizar
   * @param moviles a actualizar
   * @param token token de sesion
   * @return mensaje de confirmación de moviles actualizado
   */
  @PutMapping(value = "/actualizarMoviles/{id}")
  public ResponseEntity actualizarMoviles(@PathVariable Integer id, @RequestBody Movil moviles, @ModelAttribute Token token) {
    return servicioMoviles.actualizarMoviles(moviles, id, token.getLlave());
  }
  
  @GetMapping(value = "/mostrarMovilesPorNumero/{idMovil}")
  public ResponseEntity<Movil> buscarPornumeroMovil(@PathVariable(value = "idMovil") final int idMovil, @ModelAttribute Token token) {
    return servicioMoviles.buscarPornumeroMovil(idMovil, token.getLlave());
  }
  
  @DeleteMapping(value = "/borrarMoviles/{idMovil}")
  public ResponseEntity eliminarMoviles(@PathVariable(name = "idMovil")int idMovil, @ModelAttribute Token token) {
    return servicioMoviles.eliminarMoviles(idMovil, token.getLlave());
  }
  
  @GetMapping(value = "/mostrarTiposMoviles")
  public ResponseEntity<List<TipoMovil>> obtenerTiposMoviles(@ModelAttribute Token token) {
    return servicioTiposMoviles.mostrarTodos(token.getLlave());
  }
  
  @PostMapping(value = "/guardarTipoMovil/")
  public ResponseEntity guardarTiposMoviles(@RequestBody final TipoMovil tiposMoviles, @ModelAttribute Token token) {
    return servicioTiposMoviles.guardarTiposMoviles(tiposMoviles,token.getLlave());
  }
  
  /**
   * este metodo actualiza los datos de un tipoMovil
   *
   * @param id id del tipomovil a actualizar
   * @param tiposMoviles
   * @body tiposmoviles a actualizar
   * @param token token de sesion
   * @return mensaje de confirmación de tiposmoviles actualizado
   */
  @PutMapping(value = "/actualizarTiposMoviles/{id}")
  public ResponseEntity actualizarTiposMoviles(@PathVariable Integer id, @RequestBody TipoMovil tiposMoviles, @ModelAttribute Token token) {
    return servicioTiposMoviles.actualizarTiposMoviles(tiposMoviles, id, token.getLlave());
  }
  
  @PostMapping(value = "/borrarTiposMoviles")
  public ResponseEntity eliminarTiposMoviles(TipoMovil tiposMoviles, @ModelAttribute Token token) {
    return servicioTiposMoviles.eliminarTiposMoviles(tiposMoviles, token.getLlave());
  }
  
}
