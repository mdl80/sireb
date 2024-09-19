
package com.SIREB.repositorios;

import com.SIREB.modelos.OtrosServicios;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Esta interface proporciona los metodos que interactuan con la
 * db
 * @author Marcelo Llanes
 */
public interface RepositorioOtrosServicios extends JpaRepository<OtrosServicios, Integer> {
  
  /**
   * este metodo busca en la base de datos si existe una entidad con el nombre de 
   * servicio dado
   * @param servicio el nombre de servicio
   * @return true si existe, false en caso contrario
   */
  public boolean existsOtrosServiciosByServicio(String servicio);
  
  /**
   * este metodo devuelve un servicio buscandolo a traves de su nombre
   * @param servicio el nombre de servicio a buscar
   * @return el servicio buscado
   */
  public OtrosServicios findByServicio(String servicio);
  
}