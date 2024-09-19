package com.SIREB.servicios;

import com.SIREB.modelos.Sesion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.MINUTES;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 *
 * @author Kike
 */
@Slf4j
@Service
public class ServicioSesion {
    private final List<Sesion> sesionesEnMemoria = new ArrayList();
    public boolean Sesion(String nombre, Integer idBombero, Integer idCuartel){
        Date ahora = new Date();
        if(sesionesEnMemoria.isEmpty()){
            Sesion sesionNueva = new Sesion(nombre, idBombero, idCuartel, ahora, ahora);
            sesionesEnMemoria.add(sesionNueva);
            return true;        
        }else{
        for(Sesion sesion:sesionesEnMemoria){
            if (!sesion.getKey().equals(nombre)) {
                Sesion sesionNueva = new Sesion(nombre, idBombero, idCuartel, ahora, ahora);
                sesionesEnMemoria.add(sesionNueva);
                return true;
            }else if(sesion.getKey().equals(nombre) && !ValidarHora(sesion.getUltimoCambio())){
                sesionesEnMemoria.remove(sesion);
                return false;
            }else if(sesion.getKey().equals(nombre) && ValidarHora(sesion.getUltimoCambio())){
                sesion.setUltimoCambio(ahora);
                return true;
            }
        }
        return false;
        }
    }
    
    public boolean Validar(String nombre){
        Date ahora = new Date();
        for(Sesion sesion:sesionesEnMemoria){
            if(sesion.getKey().equals(nombre) && !ValidarHora(sesion.getUltimoCambio())){
                sesionesEnMemoria.remove(sesion);
                return false;
            }else if(sesion.getKey().equals(nombre) && ValidarHora(sesion.getUltimoCambio())){
                sesion.setUltimoCambio(ahora);
                return true;
            }
        }
        return false;
    }
    
    public List leerSesiones(){
               return(sesionesEnMemoria);
    }
    
    public Sesion leerSesion(String llave){
        for(Sesion sesion:sesionesEnMemoria){
            if(sesion.getKey().equals(llave)){
                return(sesion);
            }
        }
        return null;
    }
    
    private boolean ValidarHora(Date fecha){
        Date ahora = new Date();
        long duracion = MILLISECONDS.convert(20, MINUTES);
        long diferencia = ahora.getTime() - fecha.getTime();
        if (diferencia >= duracion) {
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * este metodo elimina de la lista de sesiones ,la sesion que tiene
     * el token de usuario ingresado
     * @param token el token de usuario 
     */
    public void cerrarSesion(String token){
      
      Predicate<Sesion> condicion = (t) -> (t.getKey().equals(token));
      sesionesEnMemoria.removeIf(condicion);
    }
}
