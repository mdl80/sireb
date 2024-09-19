package com.SIREB.modelos;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa la entidad UsuarioContraseña
 * correspondiente al usuario y contraseña de un bombero
 * a traves de esta entidad se valida el ingreso al sistema
 * @author Marcelo Llanes
 */
@Getter
@Setter
@Entity
@Table(name = "UsuarioContraseña")
public class UsuarioContraseña implements Serializable  {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuarioContraseña;
 @Column(name = "usuario")
  private String usuario;
 @Column(name = "contraseña")
  private String contraseña;
 @Column(name = "idBomber", insertable = false, updatable = false)
  private Integer idBombero;
 
 @OneToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "idBombero")
 private Bombero bombero;
  
  public UsuarioContraseña() {
  }
 
  public UsuarioContraseña(String usuario,String contraseña){
    this.usuario = usuario;
    this.contraseña = contraseña;
  }

  public UsuarioContraseña(String usuario,String contraseña, Integer idBombero){
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.idBombero = idBombero;
  }

    public Bombero getBombero() {
        return bombero;
    }

    public void setBombero(Bombero bombero) {
        this.bombero = bombero;
    }  
  
}
