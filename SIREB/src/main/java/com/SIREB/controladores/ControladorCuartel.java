package com.SIREB.controladores;

import com.SIREB.modelos.Cuartel;
import com.SIREB.modelos.Token;
import com.SIREB.servicios.ServicioCuartel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kike
 */
@Controller
@RequestMapping("/cuartel")
public class ControladorCuartel {
    @Autowired
    private ServicioCuartel servicioCuartel;
  
  
    @GetMapping("/mostrarCuartel/{idCuartel}")
    public ResponseEntity<Cuartel> buscarPorId(@PathVariable Integer idCuartel, @ModelAttribute Token token) {
        return servicioCuartel.buscarPorId(idCuartel,token.getLlave());
    }

    @PutMapping("/actualizar/{idCuartel}")
    public ResponseEntity<Cuartel> guardarCuartel(@PathVariable Integer idCuartel, @RequestBody Cuartel cuartel, @ModelAttribute Token token) {
        return servicioCuartel.guardarCuartel(cuartel, token.getLlave());
    }

}
