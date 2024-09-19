
package com.SIREB.validadores;

import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioDespliegueBombero;
import com.SIREB.repositorios.RepositorioDespliegueMovil;
import com.SIREB.repositorios.RepositorioEstado;
import com.SIREB.repositorios.RepositorioIntervencion;
import com.SIREB.repositorios.RepositorioMovil;
import com.SIREB.repositorios.RepositorioTipoAviso;
import com.SIREB.repositorios.RepositorioTipoIntervencion;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marcelo
 */
public class ValidadorDespliegueMovil {
    @Autowired
    private ValidadorMovil validadorMovil;
    private ValidadorIntervencion validadorIntervencion;
    private RepositorioDespliegueBombero repositorioDespliegueBombero;
    private RepositorioDespliegueMovil repositorioDespliegueMovil;
    private RepositorioTipoAviso repositorioTipoAviso;
    private RepositorioEstado repositorioEstado;
    private RepositorioBarrioZona repositorioBarrioZona;
    private RepositorioBombero repositorioBombero;
    private RepositorioTipoIntervencion repositorioTipoIntervencion;
    private RepositorioMovil repositorioMovil;
    private RepositorioIntervencion repositorioIntervencion;
    
    @Autowired
    public ValidadorDespliegueMovil(ValidadorMovil validadorMovil, ValidadorIntervencion validadorIntervencion, RepositorioDespliegueBombero repositorioDespliegueBombero, RepositorioDespliegueMovil repositorioDespliegueMovil, RepositorioTipoAviso repositorioTipoAviso, RepositorioEstado repositorioEstado, RepositorioBarrioZona repositorioBarrioZona, RepositorioBombero repositorioBombero, RepositorioTipoIntervencion repositorioTipoIntervencion, RepositorioMovil repositorioMovil, RepositorioIntervencion repositorioIntervencion) {
        this.validadorMovil = validadorMovil;
        this.validadorIntervencion = validadorIntervencion;
        this.repositorioDespliegueBombero = repositorioDespliegueBombero;
        this.repositorioDespliegueMovil = repositorioDespliegueMovil;
        this.repositorioTipoAviso = repositorioTipoAviso;
        this.repositorioEstado = repositorioEstado;
        this.repositorioBarrioZona = repositorioBarrioZona;
        this.repositorioBombero = repositorioBombero;
        this.repositorioTipoIntervencion = repositorioTipoIntervencion;
        this.repositorioMovil = repositorioMovil;
        this.repositorioIntervencion = repositorioIntervencion;
    }
    
     
    public HashMap<Boolean,HashMap> validarDespliegue(Integer idIntervencion,Integer idMovil){
        HashMap<Boolean,HashMap> errores = new HashMap<>();
        HashMap<String,Boolean> listaErrores = new HashMap<>();
        HashMap<Boolean,HashMap> listaErroresIntervencion;
        HashMap<Boolean,HashMap> listaErroresMovil ;
        validadorIntervencion = new ValidadorIntervencion(repositorioDespliegueBombero, repositorioDespliegueMovil, repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero, repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        validadorMovil = new ValidadorMovil(repositorioMovil);
        listaErroresIntervencion = validadorIntervencion.validarId(idIntervencion);
        listaErroresMovil = validadorMovil.validarIdMovil(idMovil);
        try {
            if(listaErroresIntervencion.containsKey(false)){
                listaErrores.putAll(listaErroresIntervencion.get(false));
            }
            if(listaErroresMovil.containsKey(false)){
                listaErrores.putAll(listaErroresMovil.get(false));
            }
            if(listaErrores.containsValue(false)){
                errores.put(false, listaErrores);
                return errores;
            }else{
                
                if(repositorioDespliegueMovil.existsByIdIntervencionAndIdMovil(idIntervencion, idMovil)){
                    listaErrores.put("El id " + idMovil + " ya se encuentra desplegado en intervencion id " + idIntervencion , false);
                }
            }
            if(listaErrores.containsValue(false)){
                errores.put(false, listaErrores);
            }else{
                errores.put(true, listaErrores);
            }
        } catch (Exception e) {
            
        }
        return errores;
    }   
}
