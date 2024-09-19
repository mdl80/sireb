package com.SIREB.modelos;

import com.SIREB.modelos.enums.FactorSanguineo;
import com.SIREB.modelos.enums.Genero;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

/**
 * La clase Bombero define un bombero dentro del cuartel y contiene todos los
 * datos relativos de ese bombero
 *
 * @author Marcelo Llanes
 */
@Entity
@Table(name = "Bomberos")
public class Bombero implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idBombero")
  private Integer idBombero;

  @Column(name = "DNI")
  private String DNI;

  @Column(name = "nombre1")
  private String nombre1;

  @Column(name = "nombre2")
  private String nombre2;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "telefonoCasa")
  private String telefonoCasa;

  @Column(name = "TelefonoCelular")
  private String telefonoCelular;

  @Column(name = "direccion")
  private String direccion;

  @Column(name = "fechaNacimiento")
  private Date fechaNacimiento;

  @Column(name = "edad")
  private Integer edad;

  @Column(name = "factorSanguineo")
  private String factorSanguineo;

  @Column(name = "genero")
  private String genero;

  @Column(name = "fechaAlta")
  private Date fechaAlta;

  @Column(name = "fechaBaja")
  private Date fechaBaja;

  @Column(name = "idMotivoBaja")
  private Integer idMotivoBaja;

  @Column(name = "idGrado")
  private Integer idGrado;

  @Column(name = "idCuartel")
  private Integer idCuartel;

  /**
   * Constructor con todos los parametros
   * @param DNI DNI del bombero
   * @param nombre1 primer nombre del bombero
   * @param nombre2 segundo nombre del bombero
   * @param apellido apellido del bombero
   * @param telefonoCasa telefono de contacto del bombero
   * @param telefonoCelular telefono celular del bombero
   * @param direccion direccion del bombero
   * @param fechaNacimiento fecha de nacimiento del bombero en forma YYYY/MM/DD
   * @param edad edad del bombero
   * @param factorSanguineo factor sanguineo del bombero
   * @param genero genero del bombero
   * @param fechaAlta fecha de alta del bombero
   * @param fechaBaja fecha de baja del bombero
   * @param idMotivoBaja id del motivo de baja del bombero
   * @param idGrado ,id del idGrado del bombero
     * @param idCuartel
   */
  //tener en cuenta que en el campo de clase genero y factorsanguineo se debe guardar String y no enum 
  public Bombero(String DNI, String nombre1, String nombre2, String apellido, String telefonoCasa, String telefonoCelular, 
      String direccion, Date fechaNacimiento, Integer edad, FactorSanguineo factorSanguineo, Genero genero, Date fechaAlta, 
        Date fechaBaja, Integer idMotivoBaja, Integer idGrado, Integer idCuartel) {
    this.DNI = DNI;
    this.nombre1 = nombre1;
    this.nombre2 = nombre2;
    this.apellido = apellido;
    this.telefonoCasa = telefonoCasa;
    this.telefonoCelular = telefonoCelular;
    this.direccion = direccion;
    this.fechaNacimiento = fechaNacimiento;
    this.edad = edad;
    this.factorSanguineo = factorSanguineo.getValue();
    this.genero = genero.getValue();
    this.fechaAlta = fechaAlta;
    this.fechaBaja = fechaBaja;
    this.idMotivoBaja = idMotivoBaja;
    this.idGrado = idGrado;
    this.idCuartel = idCuartel;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.idBombero);
    hash = 59 * hash + Objects.hashCode(this.DNI);
    hash = 59 * hash + Objects.hashCode(this.idGrado);
    hash = 59 * hash + Objects.hashCode(this.idCuartel);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Bombero other = (Bombero) obj;
    if (!Objects.equals(this.DNI, other.DNI)) {
      return false;
    }
    if (!Objects.equals(this.nombre1, other.nombre1)) {
      return false;
    }
    if (!Objects.equals(this.nombre2, other.nombre2)) {
      return false;
    }
    if (!Objects.equals(this.apellido, other.apellido)) {
      return false;
    }
    if (!Objects.equals(this.telefonoCasa, other.telefonoCasa)) {
      return false;
    }
    if (!Objects.equals(this.telefonoCelular, other.telefonoCelular)) {
      return false;
    }
    if (!Objects.equals(this.direccion, other.direccion)) {
      return false;
    }
    if (!Objects.equals(this.factorSanguineo, other.factorSanguineo)) {
      return false;
    }
    if (!Objects.equals(this.genero, other.genero)) {
      return false;
    }
    if (!Objects.equals(this.idBombero, other.idBombero)) {
      return false;
    }
    if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
      return false;
    }
    if (!Objects.equals(this.edad, other.edad)) {
      return false;
    }
    if (!Objects.equals(this.fechaAlta, other.fechaAlta)) {
      return false;
    }
    if (!Objects.equals(this.fechaBaja, other.fechaBaja)) {
      return false;
    }
    if (!Objects.equals(this.idMotivoBaja, other.idMotivoBaja)) {
      return false;
    }
    if (!Objects.equals(this.idGrado, other.idGrado)) {
      return false;
    }
    return Objects.equals(this.idCuartel, other.idCuartel);
  }
  
}
