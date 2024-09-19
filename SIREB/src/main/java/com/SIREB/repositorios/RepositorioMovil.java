package com.SIREB.repositorios;

import com.SIREB.modelos.Movil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wanda
 */

    
public interface RepositorioMovil extends JpaRepository <Movil,Integer>{
     
 /**
   *  busqueda de un movil por Numero de movil
   * @param numeroMovil numeroMovil del movil a buscar
   * @return Movil
   */
      
public Boolean existsByNumeroMovil(int numeroMovil);

}
