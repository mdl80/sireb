package com.SIREB.repositorios;

import com.SIREB.modelos.Bombero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * esta interface proporciona todos los metodos necesarios para trabajar
 * en la db SIREB con la tabla Bombero
 * @author Marcelo Llanes
 */
@Repository
public interface RepositorioBombero extends JpaRepository <Bombero,Integer>{

  /**
   * este metodo se encarga de la busqueda de un bombero por DNI
   * @param dni dni del bombero a buscar
   * @return Bombero
   */
@Query(value = "SELECT * FROM Bomberos where DNI = :dni", nativeQuery = true)  
public Bombero buscarPorDNI(@Param("dni") String dni);

/**
 * este metodo se encarga de la busqueda de un bombero por el primer nombre
 * @param nombre el nombre del bombero
 * @return Bombero
 */
@Query(value ="SELECT *FROM Bomberos like nombre1 = : 'nombre%' ", nativeQuery = true)
public Bombero buscarPorNombreBombero(@Param("nombre")String nombre);

/**
 * Metodo sobrecargado , se encarga de la busqueda de un bombero por el primer 
 * y segundo nombre 
 * @param nombre1 primer nombre del bombero
 * @param nombre2 segundo nombre del bombero
 * @return Bombero
 */
@Query(value = "SELECT * FROM Bomberos like nombre1 = :'1nombre%' and nombre2 = :'2nombre%'", nativeQuery = true)
 public Bombero BuscarPorNombreBombero(@Param("1nombre")String nombre1,@Param("2nombre")String nombre2);
  /**
   * este metodo sw encarga de la busqueda de un bombero por apellido
   * @param apellido apellido del bombero
   * @return Bombero
   */
@Query(value = "SELECT * FROM Bomberos like apellido = :'apellido%'", nativeQuery = true)
public Bombero buscarBomberoPorApellido(@Param("apellido")String apellido);
/**
 * este metodo se encarga de la busqueda de bomberos por grado(Rango)
 * @param Grado
 * @return una lista de Bomberos
 */
@Query(value = "SELECT * FROM Bomberos INNER JOIN Grados where grado like 'grado%'", nativeQuery = true)
public List<Bombero> buscarPorGrado(String Grado);

/**
 * este metodo devuelve todos los bomberos activos (que no han sido dados de baja
 * @return Lista de bomberos activos
 */
@Query(value = "SELECT * FROM Bomberos WHERE fechaBaja IS NULL", nativeQuery = true)
public List<Bombero> BuscarBomberosActivos();

/**
 * este metodo devuelve una lista de bomberos que tengan el factor sanguineo seleccionado
 * @return lista de bomberos
 */
@Query(value = "SELECT * FROM Bomberos WHERE factorSanguineo like 'factor%'", nativeQuery = true)
public List<Bombero> buscarBomberoPorFactorSanguineo();


/**
 * este método se agregó para debuguear el método delete, no debería utilizarse en el futuro
 * y se va a deprecatear.
 * @param id 
 */
@Query(value = "DELETE FROM Bomberos WHERE idBombero = :id", nativeQuery = true)
@Modifying(clearAutomatically = true)
@Transactional
public void borrar(@Param("id") Integer id);

public boolean existsByDNI(String dni);
}
