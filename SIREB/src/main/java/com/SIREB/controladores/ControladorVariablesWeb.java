package com.SIREB.controladores;

import com.SIREB.servicios.ServicioVariablesWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kike
 */
@Controller
@RequestMapping("/variablesWeb")
public class ControladorVariablesWeb {
    @Autowired
    private ServicioVariablesWeb servicioVariablesWeb;
    @GetMapping("/leer/{idCuartel}")
      public ResponseEntity mostrarVariables(@PathVariable(value = "idCuartel") final Integer idCuartel) {
              return servicioVariablesWeb.mostrarTodos(idCuartel);

      }
}
