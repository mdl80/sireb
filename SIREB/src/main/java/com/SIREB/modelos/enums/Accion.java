package com.SIREB.modelos.enums;

/**
 * se enumeran las acciones que puede ser llevadas a cabo por un usuario
 * @author Marcelo Llanes
 */
public enum Accion {
  ACTUALIZAR("Actualizar","Actualizo"),
  AGREGAR("Agregar","Agrego"),
  AUTENTICAR("Autenticar","Autenticado"),
  AUTORIZAR("Autorizar","Autorizado"),
  EDITAR("Editar","Edito"),
  ELIMINAR("Eliminar","Elimino"),
  GUARDAR("Guardar","Guardo"),
  LISTAR("Listar","Listo"),
  MOSTRAR("Mostrar","Mostro"),
  VALIDAR("Validar","Valido");
  
  /**
   * valor de la accion actual
   */
  private String actual;
  /**
   * valor de la accion pasada
   */
  private String pasado;

  private Accion(String actual,String pasado) {
    this.actual = actual;
    this.pasado = pasado;
  }
  /**
   * devuelve el valor de la accion presente
   * @return la accion presente
   */
  public String getActual(){
    return actual;
  }
  /**
   * devuelve el valor de la accion pasada
   * @return la accion pasada
   */
  public String getPasado(){
    return pasado;
  }
  
}
