package com.SIREB.validadores;

import com.SIREB.modelos.UsuarioContraseña;

/**
 * Esta clase valida los datos ingresados que utilizara el servicio
 * UsuarioContraseña los datos a validar seran usuario y contraseña
 * se realiza una verificacion de clase antes de realizar la validacion 
 * de usuario y contraseña
 *
 * @author Marcelo Llanes
 */
public class ValidadorUsuarioContraseña {

  public boolean validarUsuarioContrasenia(UsuarioContraseña usuario) {
    boolean validado = false;
    try {
      if (usuario.getClass() == UsuarioContraseña.class) {
        validado = (comprobarUsuario(usuario) && comprobarContrasenia(usuario));
      }
    } catch (Exception e) {
    }
    return validado;
  }

  /**
   * este metodo realiza las comprobaciones para validar el user de un usuario
   *
   * @param usuario el usuario a validar
   * @return true si los datos del usuario son validados
   */
  private boolean comprobarUsuario(UsuarioContraseña usuario) {
    return (comprobarVacioUsuario(usuario) && comprobarLongitudUsuario(usuario)
      && comprobarEspecialesUsuario(usuario));

  }

  /**
   * comprueba que el usuario no sea un dato vacio o de espacios en blanco
   *
   * @param usuario el usuario a comprobar
   * @return true si el usuario es validado,false en caso de que no sea validado
   */
  private boolean comprobarVacioUsuario(UsuarioContraseña usuario) {
    return !(usuario.getUsuario().isBlank());
  }

  /**
   * comprueba la longitud minima del nombre de usuario
   *
   * @param usuario usuario a comprobar
   * @return true si el nombre de usuario es mayor o igual a 5 y menor a 15,
   * false en caso contrario
   */
  private boolean comprobarLongitudUsuario(UsuarioContraseña usuario) {
    return !((usuario.getUsuario().length() <= 5) || (usuario.getUsuario().length() > 15));
  }

  /**
   * comprueba que no se hayan incluido caracteres especiales en el nombre de
   * usuario
   *
   * @param usuario a comprobar
   * @return verdadero si el usuario es validado , false en caso contrario
   */
  private boolean comprobarEspecialesUsuario(UsuarioContraseña usuario) {
    return !usuario.getContraseña().matches("/\\W+/g");
  }

  /**
   * este metodo realiza las comprobaciones para validar la contraseña de un
   * usuario
   *
   * @param usuario el usuario a validar
   * @return true si la contraseña es validada , false en caso contrario
   */
  private boolean comprobarContrasenia(UsuarioContraseña usuario) {
    return (comprobarLongitudContraseña(usuario) && comprobarVacioContraseña(usuario)
      && comprobarAlfaNumContrasenia(usuario));
  }

  /**
   * comprueba si la contraseña esta vacia o con espacios en blanco
   *
   * @param usuario el usuario a comprobar
   * @return true si la contraseña es validada, false en caso contrario
   */
  private boolean comprobarVacioContraseña(UsuarioContraseña usuario) {
    return !(usuario.getContraseña().isBlank());
  }

  /**
   * comprueba que la longitud de la contraseña sea mayor a 5 y menor a 15
   * alfanumerica
   *
   * @param usuario el usuario a comprobar
   * @return true si la longitud de la contraseña es validada, false en caso
   * contrario
   */
  private boolean comprobarLongitudContraseña(UsuarioContraseña usuario) {
    return !(usuario.getContraseña().length() <= 5 || usuario.getContraseña().length() > 15);
  }

  /**
   * comprueba que la contraseña sea alfanumerica , tenga una mayuscula y puede
   * tener un caracter especial
   *
   * @param usuario el usuario a comprobar
   * @return true si la contraseña es validada , false en caso contrario
   */
  private boolean comprobarAlfaNumContrasenia(UsuarioContraseña usuario) {
    return (usuario.getContraseña().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,15}$"));
  }
}
