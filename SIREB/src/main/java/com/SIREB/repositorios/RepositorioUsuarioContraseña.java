package com.SIREB.repositorios;

import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.UsuarioContraseña;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Esta Interface me proporciona acceso a la tabla UsuariosContraseña y
 * proporciona todos los metodos con los que puedo trabajar en ella .
 *
 * @author Marcelo Llanes
 */
@Repository
public interface RepositorioUsuarioContraseña extends JpaRepository<UsuarioContraseña, Integer> {

  @Query(value = "SELECT COUNT(usuario) AS cantidad FROM UsuarioContraseña uc  WHERE uc.usuario = :user AND uc.contraseña = :pass" , nativeQuery = true)
  public int validarUsuarioContraseña(@Param("user") String user, @Param("pass") String pass);
  
  @Query(value = "SELECT count(*) FROM UsuarioContraseña",nativeQuery = true)
  public int contarUC();
  
  @Query(value = "SELECT * FROM UsuarioContraseña WHERE usuario = :usu AND contraseña = :clave", nativeQuery = true)  
  public UsuarioContraseña buscarPorUP(@Param("usu") String usu, @Param("clave") String clave);

  @Query(value = "SELECT * FROM UsuarioContraseña INNER JOIN Bomberos ON UsuarioContraseña.idBomber = Bomberos.idBombero WHERE usuario = :usu AND contraseña = :clave", nativeQuery = true)
  public UsuarioContraseña buscar(@Param("usu") String usu, @Param("clave") String clave);
  
}
