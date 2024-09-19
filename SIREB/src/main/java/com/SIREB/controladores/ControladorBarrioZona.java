package com.SIREB.controladores;

import com.SIREB.modelos.BarrioZona;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioBarrioZona;
import java.util.List;
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
 * @author kike
 */
@RestController
@RequestMapping("/barrioszonas")
public class ControladorBarrioZona {
    @Autowired
    private ServicioBarrioZona servicioBarrioZona;
    
    @PostMapping(value="/agregar")
    public ResponseEntity agregarBarrioZona(@RequestBody final BarrioZona barrioZona, @ModelAttribute Token token){
        return servicioBarrioZona.agregarBarrioZona(barrioZona, token.getLlave());
    }
    
    @GetMapping(value = "/mostrarTodas")
    public ResponseEntity<List<BarrioZona>> obtenerBarriosZonas(@ModelAttribute Token token) {
        return servicioBarrioZona.mostrarTodos(token.getLlave());
    }
    
    @GetMapping(value = "/mostrar/{id}")
    public BarrioZona mostrarBarrioZona(@PathVariable(value = "id") final Integer id, @ModelAttribute Token token) {
        return servicioBarrioZona.buscarPorId(id);
    }
    
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity eliminarBarrioZona(@PathVariable(value = "id") final Integer id, @ModelAttribute Token token) {
        return servicioBarrioZona.eliminarBarrioZona(id, token.getLlave());
    }

    @PutMapping(value = "/actualizar/{id}")
    public ResponseEntity Actualizar(@PathVariable int id, @RequestBody BarrioZona barrioZona, @ModelAttribute Token token) {
        return servicioBarrioZona.actualizarBarrioZona(barrioZona, id, token.getLlave());
    }

}
