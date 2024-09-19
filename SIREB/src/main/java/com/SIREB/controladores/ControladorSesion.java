package com.SIREB.controladores;

import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioSesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kike
 */
@RestController
@RequestMapping("/enSesion")
public class ControladorSesion {
    
    @Autowired
    private ServicioSesion sesionServicio;
    
    
    @GetMapping(value="/validar/{llave}")
    public ResponseEntity<Boolean> validar(@PathVariable(value = "llave") final String llave){
        try{
            return ResponseEntity.ok(sesionServicio.Validar(llave));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    
    }
    @GetMapping(value="/leerSesiones")

    public ResponseEntity <List> leerSesiones(){
        try{
            return ResponseEntity.ok(sesionServicio.leerSesiones());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    
    }
    
    @GetMapping(value = "/cerrarSesion")
    public ResponseEntity cerrarSesion(@ModelAttribute Token token){
      try {
        if(sesionServicio.Validar(token.getLlave())){
          sesionServicio.cerrarSesion(token.getLlave());
        }else{
          return  ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
      } catch (Exception e) {
      }
      return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    
}
