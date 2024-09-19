package com.SIREB.repositorios;

import com.SIREB.modelos.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Kike
 */
public interface RepositorioEventos extends JpaRepository <Evento,Integer>{

  /**
   * este metodo se encarga de la busqueda de eventos por tipo
   * @param tipo es el tipo de evento
   * @return Lista de Evento
   */
    
    @Query(value = "SELECT * FROM Eventos WHERE Tipo = :tipo ORDER BY Fecha DESC limit 20", nativeQuery = true)  
    public List<Evento> buscarPorTipo(@Param("tipo") String tipo);

  /**
   * este metodo se encarga de la busqueda de eventos por id de Evento
   * @param id es el identificador del evento
   * @return Evento
   */
    
    @Query(value = "SELECT * FROM Eventos WHERE idEventos = :idEvento", nativeQuery = true)  
    public Evento buscarPorId(@Param("idEvento") Integer idEvento);

}
