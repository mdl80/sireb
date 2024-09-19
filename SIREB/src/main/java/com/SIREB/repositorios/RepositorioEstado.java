
package com.SIREB.repositorios;

import com.SIREB.modelos.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * esta interface es la responsable de interactuar con la DB
 * @author Marcelo Llanes
 */
public interface RepositorioEstado extends JpaRepository<Estado,Integer>{
  
}
