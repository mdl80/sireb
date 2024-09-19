package com.SIREB.repositorios;

import com.SIREB.modelos.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * esta interface proporciona todos los metodos necesarios para trabajar con la
 * base de datos Sireb.
 *
 * @author Marcelo Llanes
 */
@Repository
public interface RepositorioGrado extends JpaRepository<Grado, Integer>{
  
 
  /**
   * devuelve un Grado a partir de un nombre de grado
   * @param nombreGrado el nombre de grado a buscar 
   * @return el grado buscado , en caso contrario Null
   */
  @Query(value = "SELECT * FROM Grados WHERE grado = :nombreGrado" , nativeQuery = true)
  public Grado buscarPorGrado(@Param("nombreGrado") String nombreGrado);
  /**
   * devuelve una coleccion de grados de la db
   * @return una coleccion de grados
   */
  @Query(value = "SELECT * FROM Grados ORDER BY idGrado", nativeQuery = true)
  public Grado mostrarTodos();
 /**
  * verifica en la db si el grado existe,por defecto solo debe existir un grado
  * @param grado el grado a verificar
  * @return 0 si el grado no existe, 1 si el grado existe
  */
  @Query(value = "SELECT COUNT(grado) FROM SIREB.Grados where grado = :nombreGrado",nativeQuery = true)
  public int existeGrado(@Param("nombreGrado")String grado);
  
  public boolean existsGradoByGrado(String grado);
}
