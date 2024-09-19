package com.SIREB.servicios;

import com.SIREB.modelos.DespliegueMovil;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioDespliegueBombero;
import com.SIREB.repositorios.RepositorioDespliegueMovil;
import com.SIREB.repositorios.RepositorioEstado;
import com.SIREB.repositorios.RepositorioIntervencion;
import com.SIREB.repositorios.RepositorioMovil;
import com.SIREB.repositorios.RepositorioTipoAviso;
import com.SIREB.repositorios.RepositorioTipoIntervencion;
import com.SIREB.validadores.ValidadorDespliegueMovil;
import com.SIREB.validadores.ValidadorIntervencion;
import com.SIREB.validadores.ValidadorMovil;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * esta clase va a devolver una respuesta de operacion sobre los despliegues de
 * moviles
 *
 * @author kike
 */
@Service
public class ServicioDespliegueMovil {

    @Autowired
    private RepositorioMovil repositorioMovil;
    @Autowired
    private RepositorioDespliegueBombero repositorioDespliegueBombero;
    @Autowired
    private RepositorioDespliegueMovil repositorioDespliegueMovil;
    @Autowired
    private RepositorioTipoAviso repositorioTipoAviso;
    @Autowired
    private RepositorioEstado repositorioEstado;
    @Autowired
    private RepositorioBarrioZona repositorioBarrioZona;
    @Autowired
    private RepositorioBombero repositorioBombero;
    @Autowired
    private RepositorioTipoIntervencion repositorioTipoIntervencion;
    @Autowired
    private RepositorioIntervencion repositorioIntervencion;

    private ValidadorMovil validadorMovil;
    @Autowired
    private ValidadorIntervencion validadorIntervencion;
    private ValidadorDespliegueMovil validadorDespliegueMovil;

    ServicioRespuestaAccion respuesta;

    public ResponseEntity agregarMovil(Integer idIntervencion, Integer idMovil) {
        respuesta = new ServicioRespuestaAccion();
        validadorDespliegueMovil = new ValidadorDespliegueMovil(validadorMovil, validadorIntervencion, repositorioDespliegueBombero, repositorioDespliegueMovil, repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero, repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        HashMap<Boolean, HashMap> errores = validadorDespliegueMovil.validarDespliegue(idIntervencion, idMovil);
        LocalDateTime horaSalida = LocalDateTime.now() ;

        try {
            if (errores.containsKey(true)) {
                DespliegueMovil despliegueMovil = new DespliegueMovil();
                despliegueMovil.setTicket(repositorioIntervencion.findById(idIntervencion).get().getTicket());
                despliegueMovil.setIdMovil(idMovil);
                despliegueMovil.setHoraSalida(horaSalida);
                despliegueMovil.setHoraLlegada(null);
                despliegueMovil.setIdIntervencion(idIntervencion);
                repositorioDespliegueMovil.save(despliegueMovil); 
                if (repositorioDespliegueMovil.existsByIdIntervencionAndIdMovil(idIntervencion, idMovil)) {
                    respuesta.crearRespuestaAccion(ServicioDespliegueMovil.class, Accion.AGREGAR, true, errores);
                } else {
                    respuesta.crearRespuestaAccion(ServicioDespliegueMovil.class, Accion.AGREGAR, false, errores);
                }
            } else {
                respuesta.crearRespuestaAccion(ServicioDespliegueMovil.class, Accion.AGREGAR, false, errores);
            }
        } catch (Exception e) {
            return new ResponseEntity("un error a ocurrido:" + e.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

//hora de llegada se refiere a la hora de llegada del movil al sitio del siniestro
    //FALTA ELIMINAR
}
