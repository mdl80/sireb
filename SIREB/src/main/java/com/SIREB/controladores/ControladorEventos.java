package com.SIREB.controladores;

/**
 *
 * @author Kike
 */

import com.SIREB.modelos.Evento;
import com.SIREB.servicios.ServicioEventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * esta clase brinda acceso a los endpoints a traves de los cuales se registra
 * y busca eventos.
 *
 * @author Kike
 */
@RestController
@RequestMapping("/eventos")
public class ControladorEventos {
    @Autowired
    private ServicioEventos servicioEventos;

    @PostMapping(value="/agregar/")
        public ResponseEntity agregarEvento(@RequestBody final Evento evento){
        try{
            //Aún no implemtado.
            servicioEventos.agregarEvento(evento);
            return ResponseEntity.ok("Todo ok");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
        
    @GetMapping(value="/listarEventos/{tipo}")
    public ResponseEntity <List<Evento>> buscarPorTipo(@PathVariable(value = "tipo") final String tipo ){
        try{
            return ResponseEntity.ok(servicioEventos.buscarPorTipo(tipo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
