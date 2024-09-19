package com.SIREB.controladores;

import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioBombero;
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
 * ControladorBombero proporciona todos los EndPoints relacionados a Bombero
 *
 */
@Slf4j
@RestController
@RequestMapping("/bomberos")
public class ControladorBombero {

  @Autowired
  private ServicioBombero servicioBombero;

  // Endpoint para obtener una lista de x bomberos.
  /**
   * este endpoint permite obtener todos los bomberos
   *
   * @return Una lista con todos los bomberos
   */
  @GetMapping(value = "/mostrarBomberos")
  public ResponseEntity<List<Bombero>> obtenerBomberos(@ModelAttribute Token token) {
    //se quito el try con el objetivo que el servicio lanze las excepciones y las atrape
    return servicioBombero.mostrarTodos(token.getLlave());
  }

  //Método para guardar un bombero
  /**
   * este endpoint permite guardar un bombero
   *
   * @param bombero
   * @return mensaje de confirmacion de bombero guardado
   */
  @PostMapping(value = "/guardarBombero")
  public ResponseEntity guardarBombero(@RequestBody final Bombero bombero, @ModelAttribute Token token) {
    return servicioBombero.guardarBombero(bombero, token.getLlave());
  }

  /**
   * este metodo actualiza los datos de un bombero
   *
   * @param id id del bombero a actualizar
   * @param bombero bombero a actualizar
   * @param token token de sesion
   * @return mensaje de confirmación de bombero actualizado
   */
  @PutMapping(value = "/actualizarBombero/{id}")
  public ResponseEntity Actualizar(@PathVariable int id, @RequestBody Bombero bombero, @ModelAttribute Token token) {
    return servicioBombero.actualizarBombero(bombero, id, token.getLlave());
  }

  //Método para obtener bombero por dni
  /**
   * este endpoint permite buscar un bombero por dni
   *
   * @param dni dni del bombero a buscar
   * @return Un bombero
   */
  @GetMapping(value = "/mostrarBomberoPorDni/{dni}")
  public ResponseEntity<Bombero> buscarPorDNI(@PathVariable(value = "dni") final String dni, @ModelAttribute Token token) {
    return servicioBombero.buscarPorDNI(dni, token.getLlave());
  }

  /**
   * este endpoint elimina un bombero ingresando su dni
   *
   * @param dni del bombero a eliminar
   * @param token
   * @return redireccion a /bomberoEliminado si el bombero se elimino
   * correctamente
   */
  @DeleteMapping(value = "/borrarBomberoPorDni/{dni}")
  public ResponseEntity eliminarBombero(@PathVariable(value = "dni") final String dni, @ModelAttribute Token token) {
    return servicioBombero.eliminarBombero(dni, token.getLlave());

  }
}
