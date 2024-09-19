package com.SIREB.repositorios;

import com.SIREB.modelos.TipoMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wanda
*/

public interface RepositorioTipoMovil extends JpaRepository <TipoMovil,Integer>{

    
@Query(value = "SELECT * FROM TiposMoviles where tipo = :tipo", nativeQuery = true)  
public TipoMovil buscarPorTipoMovil(@Param("tipo") String tipo);
    

  
public TipoMovil findTipoMovilByTipo (String tipoMovil);
  
  /*
  Wanda controlar que ande, esto no va a funcionar!
  
  public TipoMovil buscarPorTipoMovil(@Param("tipo") String tipo);
*/
}
