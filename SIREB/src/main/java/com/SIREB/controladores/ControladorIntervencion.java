package com.SIREB.controladores;

import com.SIREB.modelos.Intervencion;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioDespliegueBomberos;
import com.SIREB.servicios.ServicioDespliegueMovil;
import com.SIREB.servicios.ServicioIntervencion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marcelo Llanes
 */
@Controller
@RequestMapping("/intervencion")
public class ControladorIntervencion {

    @Autowired
    private ServicioIntervencion servicioIntervencion;
    @Autowired
    private ServicioDespliegueBomberos servicioDespliegueBomberos;
    @Autowired
    private ServicioDespliegueMovil ServicioDespliegueMovil;

    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public ResponseEntity guardarIntervencion(@ModelAttribute Token token, @RequestBody Intervencion intervencion) {
        return servicioIntervencion.guardarIntervencion(intervencion, token.getLlave());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizarIntervencion(@RequestBody Intervencion intervencion, @PathVariable(name = "id") Integer idIntervencion,@ModelAttribute Token token) {
        return servicioIntervencion.actualizarIntervencion(intervencion, idIntervencion, token.getLlave());
    }

    @GetMapping(value = {"/mostrar/{idEstado}","/mostrar"})
    public ResponseEntity mostrarTodas(@ModelAttribute Token token,@PathVariable(name = "idEstado")Optional<Integer> idEstado) {
        return servicioIntervencion.mostrarTodo(token.getLlave(),idEstado.orElse(null));
    }

    @GetMapping("/buscarTicket/{ticket}")
    public ResponseEntity buscarPorTicket(@ModelAttribute Token token, @PathVariable(name = "ticket") String ticket) {
        return servicioIntervencion.buscarPorTicket(ticket, token.getLlave());
    }
  
    @GetMapping("buscarId/{id}")
    public ResponseEntity buscarPorId(@ModelAttribute Token token, @PathVariable(name = "id") Integer id) {
        return servicioIntervencion.buscarPorId(id, token.getLlave());
    }
    
    /**
     * este endpoint agrega bomberos a un movil desplegado en  intervencion , al no tener id de movil
     * no han sido desplegados a la intervencion pero acudieron a la convocatoria
     * @param idIntervencion id de la intervencion donde sera desplegado el bombero
     * @param idDespliegueMovil id de un movil desplegado, para la intervencion en curso,si este valor es nulo
     * significa que los bomberos acudieron al cuartel pero no se asignaron a ningun movil
     * @param listaBomberos lista de idbomberos 
     * @return una respuesta 
     */
    @PostMapping(value = {"/agregarBombero/{idIntervencion}/{listaBomberos}/{idDespliegueMovil}","/agregarBombero/{idIntervencion}/{listaBomberos}"})
    public ResponseEntity agregarDespliegueBombero(@PathVariable(name = "idIntervencion")Integer idIntervencion,
            @PathVariable(name = "listaBomberos")List<Integer> listaBomberos,
            @PathVariable(name = "idDespliegueMovil")Optional<Integer> idDespliegueMovil){
        return servicioDespliegueBomberos.agregarDespliegueBombero(idIntervencion, idDespliegueMovil.orElse(null), listaBomberos);
    }
     /**
      * este endpoint agrega un despliegue de bombero en un despliegue de movil
      * @param idIntervencion id de la intervencion 
      * @param idMovil id del movil donde se desplego el bombero
      * @param idBombero id del bombero
      * @return una respuesta
      */ 
    /*
    @PostMapping("/agregarBombero/{idIntervencion}/{idMovil}/{idBombero}")
    public ResponseEntity agregarDespliegueBomberoMovil(@PathVariable(name="idIntervencion")Integer idIntervencion,
            @PathVariable(name = "idMovil")Integer idMovil, @PathVariable(name = "idBombero")Integer idBombero){
        return servicioIntervencion.agregarDespliegueBomberoMovil(idIntervencion,idMovil,idBombero);
    }*/
    
    /**
     * este endpoint agrega moviles a una intervencion
     * @param idIntervencion el id de la intervvencion
     * @param idMovil el id del movil a agregar
     * @return una respuesta 
     */
    @PostMapping("/agregarMovil/{idIntervencion}/{idMovil}")
    public ResponseEntity agregarMovil(@PathVariable(name = "idIntervencion")Integer idIntervencion,@PathVariable(name = "idMovil")Integer idMovil){
        return ServicioDespliegueMovil.agregarMovil(idIntervencion,idMovil);
    }
}
