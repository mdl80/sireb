package com.SIREB.servicios;

import com.SIREB.modelos.MotivoBaja;
import com.SIREB.repositorios.RepositorioMotivoBaja;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wanda
 */

@Service
@Slf4j
public class ServicioMotivoBaja {
   @Autowired 
   private RepositorioMotivoBaja repositorioMotivoBaja;
  
   public MotivoBaja buscarPorId(Integer idMotivoBaja) {
   
       return repositorioMotivoBaja.findById(idMotivoBaja).get();
    }

}

    

