
package com.SIREB.repositorios;

import com.SIREB.modelos.DespliegueMovil;
import java.util.HashSet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * esta clase permite interactuar con la db
 * @author Marcelo Llanes
 */
public interface RepositorioDespliegueMovil extends JpaRepository<DespliegueMovil, Integer>{
    
    public HashSet<DespliegueMovil> findAllByIdIntervencion(Integer idIntervencion);
    public Boolean existsByIdIntervencionAndIdMovil(Integer idIntervencion,Integer idMovil);
  
}
