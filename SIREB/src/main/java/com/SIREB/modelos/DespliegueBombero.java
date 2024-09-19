package com.SIREB.modelos;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa los despliegues de bomberos,a un incidente corresponde un ticket
 * para ese ticket(incidente)concurren bomberos al cuartel,si no se los asigna a un movil 
 * el campo idMovil es nulo, si se asignaron a un movil el campoidMovil tendra el id de movil,
 * es un despliegue por bombero , por lo que una intervencion genera muchos despliegues
 * @author Marcelo Llanes
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "DespliegueBomberos")
public class DespliegueBombero {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idDespliegueBombero")
  private Integer idDespliegueBombero;
  
  @Column(name = "ticket")
  private String ticket;
  
  @Column(name = "idBombero")
  private Integer idBombero;
  
  @Column(name = "idDespliegueMovil")
  private Integer idDespliegueMovil;
  
  @Column(name = "idIntervencion")
  private Integer idIntervencion;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ticket);
        hash = 67 * hash + Objects.hashCode(this.idBombero);
        hash = 67 * hash + Objects.hashCode(this.idDespliegueMovil);
        hash = 67 * hash + Objects.hashCode(this.idIntervencion);
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
        final DespliegueBombero other = (DespliegueBombero) obj;
        if (!Objects.equals(this.ticket, other.ticket)) {
            return false;
        }
        if (!Objects.equals(this.idBombero, other.idBombero)) {
            return false;
        }
        if (!Objects.equals(this.idDespliegueMovil, other.idDespliegueMovil)) {
            return false;
        }
        return Objects.equals(this.idIntervencion, other.idIntervencion);
    }
  
  
}
