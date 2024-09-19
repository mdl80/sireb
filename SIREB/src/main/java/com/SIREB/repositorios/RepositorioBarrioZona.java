
package com.SIREB.repositorios;

import com.SIREB.modelos.BarrioZona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kike
 */
public interface RepositorioBarrioZona extends JpaRepository <BarrioZona,Integer>{
 
    @Query(value = "SELECT * FROM BarriosZonas", nativeQuery = true)
    public List<BarrioZona> buscarBarriosZonas();
    
    public boolean existsByBarrioZona(String barrioZona);
}
