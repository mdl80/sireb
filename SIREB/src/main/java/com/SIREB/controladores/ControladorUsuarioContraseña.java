package com.SIREB.controladores;

import com.SIREB.modelos.Sesion;
import com.SIREB.modelos.UsuarioContraseña;
import com.SIREB.servicios.ServicioUsuarioContraseña;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * esta clase brinda acceso a los endpoints a traves de los cuales se logra el
 * acceso al sistema
 *
 * @author Marcelo Llanes
 */

@Slf4j
@RestController
@RequestMapping("/sesion")
public class ControladorUsuarioContraseña {

  //inyectando el servicio
  @Autowired
  ServicioUsuarioContraseña servicio;

  /**
   * este metodo recibe un usuario y contraseña a ser validados para acceder al
   * sistema, esta validacion la realiza el servicio asociado
   *
   * @param usuarioContraseña el usuario y contraseña ingresados como objeto
   * @return nos envia a la pagina pricipal de sireb en caso de ser validado, en
   * caso contrario nos informa del error
   */
  @PostMapping("/validar")
  public ResponseEntity validar(@RequestBody final UsuarioContraseña usuarioContraseña) throws IOException {
    try {
      //controlando la cantidad de usuarios en la tabla y
      // validando la sesion sacando del objeto UsuarioContraseña el usuario y la contraseñ
      if (servicio.verificarCantidad()) {
          Sesion sesion = servicio.validarSesion(usuarioContraseña);
          if(sesion == null){
              return ResponseEntity.ok().body("{\"Correcto\": 0}");        
              
          }else{
              return ResponseEntity.ok().body("{\"Correcto\": 1, \n \"Key\": \""+sesion.getKey()+"\", \n \"idCuartel\": "+sesion.getIdCuartel()+"}");
          }
        //nos llevaria al menu principal(como lo hago?)
        //return ResponseEntity.created(new URI("/sesionSIREB")).build();
        //en caso de que solo este cargado admin/admin voy a la creacion del primer admin(bombero)
      } else {
        //debe redirigir a primer alta de usuario
        //return ResponseEntity.created(new URI("/primerAlta")).build();
        return ResponseEntity.ok().body("{\"Correcto\": 0}");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
