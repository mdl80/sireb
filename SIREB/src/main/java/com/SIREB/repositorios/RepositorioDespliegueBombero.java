
package com.SIREB.repositorios;

import com.SIREB.modelos.DespliegueBombero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * esta clase permite interactuar con la db 
 * @author Marcelo Llanes
 */
@Repository
public interface RepositorioDespliegueBombero extends JpaRepository<DespliegueBombero, Integer>{
  
    public List<DespliegueBombero> findAllByIdIntervencionAndIdDespliegueMovil(Integer idDespliegueIntervencion,Integer idDespliegueMovil);
    
    public boolean existsByIdIntervencionAndIdDespliegueMovil(Integer idDespliegueIntervencion,Integer idDespliegueMovil);

}
