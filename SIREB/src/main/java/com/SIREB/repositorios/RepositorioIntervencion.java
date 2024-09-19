package com.SIREB.repositorios;

import com.SIREB.modelos.Intervencion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * esta clase permite realizar los llamados a la DB
 *
 * @author Marcelo Llanes
 */
public interface RepositorioIntervencion extends JpaRepository<Intervencion, Integer> {

    /**
     * Informa si existe una intervencion para el ticket ingresado
     *
     * @param ticket el ticket a buscar
     * @return true si existe una intervencion para ese ticket, de lo contrario
     * devuelve falso
     */
    public boolean existsByTicket(String ticket);
    
    public Optional<Intervencion> findByTicket(String ticket);
    
    public List<Intervencion> findAllByIdEstado(Integer idEstado);
    public Boolean existsByIdEstado(Integer idEstado);
}
