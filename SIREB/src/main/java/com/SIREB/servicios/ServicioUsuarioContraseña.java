package com.SIREB.servicios;

import com.SIREB.modelos.Evento;
import com.SIREB.modelos.Sesion;
import com.SIREB.modelos.UsuarioContraseña;
import com.SIREB.repositorios.RepositorioUsuarioContraseña;
import java.io.IOException;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Este servicio proporciona la validacion para acceder al sistema a traves de
 * la interface RepositorioUsuarioContraseña
 *
 * @author Marcelo Llanes
 */
@Slf4j
@Service
public class ServicioUsuarioContraseña {
    @Autowired
    private ServicioEventos servicioEventos;
    
    @Autowired
    private ServicioSesion sesionServicio;
        
  @Autowired//inyeccion de dependencia
  private RepositorioUsuarioContraseña repo;
  
  /**
   * El metodo validarSesion es responsable de verificar si el usuario ingresado
   * es validado o no para acceder al sistema
   *
   * @param usuario el usuario a validar (usuario,contraseña)
   * @return True si el usuario es validado,False en caso contrario
     * @throws java.io.IOException
   */

  //private UsuarioContraseña usuario;
  public Sesion validarSesion(UsuarioContraseña usuario) throws IOException  {
      //Aca se genera un Evento
      Evento evento = new Evento();
        evento.setTipo("Sesion");
        evento.setIdBombero(0);
      if (repo.validarUsuarioContraseña(usuario.getUsuario(), usuario.getContraseña()) == 1) {
            //Se crea un nuevo objeto UsuarioContrasena, con datos de Bombero  
            UsuarioContraseña usuarioa =  repo.buscar(usuario.getUsuario(), usuario.getContraseña());
            usuario.setIdBombero(usuarioa.getIdBombero());
            String nombre = usuarioa.getBombero().getNombre1()+" "+usuarioa.getBombero().getNombre2();
            String apellido = usuarioa.getBombero().getApellido();
            //Se define el mensaje
            evento.setMensaje("El bombero "+nombre+" "+apellido+" inicio sesión con: "+usuario.getUsuario()+".");
            evento.setIdBombero(usuarioa.getIdBombero());
            String nombreBase64 = Base64.getEncoder().encodeToString((nombre+"/"+apellido).getBytes());
            //Se agrega el evento a la db.
            servicioEventos.agregarEvento(evento);
            sesionServicio.Sesion(nombreBase64, usuarioa.getIdBombero(), usuarioa.getBombero().getIdCuartel());
            return sesionServicio.leerSesion(nombreBase64);
      } else {
          return null;
    }
  }

  /**
   * verificarcantidad cuenta la cantidad de usuarios y contraseñas guardados en
   * caso de que esta sea igual a 1 significa que se encuentran cargados solo
   * usuario y contraseñas por defecto
   *
   * @return True en caso de que la cantidad de usuarios contraseñas registrados
   * sea mayor a 1 , en caso contrario False
   */
  public boolean verificarCantidad() {
    if (repo.contarUC()>=2) {
      return true;
    } else {
      return false;
    }
  }
}
