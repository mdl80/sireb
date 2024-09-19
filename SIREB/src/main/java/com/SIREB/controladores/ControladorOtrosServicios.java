package com.SIREB.controladores;

import com.SIREB.modelos.OtrosServicios;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioOtrosServicios;
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
 * proporciona todos los endpoints para otros Servicios
 * @author Marcelo Llanes
 */
@Controller
@RequestMapping("/otrosServicios")
public class ControladorOtrosServicios {
  @Autowired
  private ServicioOtrosServicios servicio;
  
  @PostMapping("/guardar")
  public ResponseEntity guardarOtroServicio(@ModelAttribute Token token, @RequestBody OtrosServicios OtroServicio){
    return servicio.guardarServicio(OtroServicio, token.getLlave());
  }
  
  @PutMapping("/actualizar/{id}")
  public  ResponseEntity actualizarOtroServicio(@ModelAttribute Token token,@RequestBody OtrosServicios otroServicio,@PathVariable(value = "id") Integer id){
    return servicio.actualizarServicio(otroServicio, id, token.getLlave());
  }
  
  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity eliminarOtroServicio(@ModelAttribute Token token,@PathVariable(value = "id") Integer id){
    return servicio.eliminarServicio(id, token.getLlave());
  }
  
  @GetMapping("/mostrarTodos")
  public ResponseEntity mostrarTodos(@ModelAttribute Token token){
    return servicio.mostrarTodos(token.getLlave());
  }
  @GetMapping("/mostrar/{id}")
  public ResponseEntity mostrar(@PathVariable(value = "id") Integer id,@ModelAttribute Token token){
    return servicio.obtenerServicio(id, token.getLlave());
  }

}
