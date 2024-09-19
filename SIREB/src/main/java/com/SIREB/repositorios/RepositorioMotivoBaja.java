package com.SIREB.repositorios;

import com.SIREB.modelos.MotivoBaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wanda
 */
@Repository
public interface RepositorioMotivoBaja extends JpaRepository<MotivoBaja, Integer>{
    
    
}
