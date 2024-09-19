package com.SIREB.servicios;

import com.SIREB.modelos.DespliegueBombero;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioDespliegueBombero;
import com.SIREB.repositorios.RepositorioDespliegueMovil;
import com.SIREB.repositorios.RepositorioIntervencion;
import com.SIREB.repositorios.RepositorioMovil;
import com.SIREB.validadores.ValidadorDespliegueBombero;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * esta clase es responsable de los despliegues de bomberos
 *
 * @author kike
 */
@Service
@Slf4j
public class ServicioDespliegueBomberos {

    @Autowired
    private RepositorioIntervencion repositoriointervencion;
    @Autowired
    private RepositorioBombero repositorioBombero;
    @Autowired
    private RepositorioDespliegueBombero repositorioDespliegueBombero;
    @Autowired
    private RepositorioDespliegueMovil repositorioDespliegueMovil;
    @Autowired
    private RepositorioMovil repositorioMovil;
    private ValidadorDespliegueBombero validadorDespliegue;
    ServicioRespuestaAccion respuesta;

    public ResponseEntity agregarDespliegueBombero(Integer idIntervencion, Integer idDespliegueMovil, List<Integer> bomberos) {
        respuesta = new ServicioRespuestaAccion();
        validadorDespliegue = new ValidadorDespliegueBombero(repositoriointervencion, repositorioBombero, repositorioDespliegueMovil, repositorioDespliegueBombero, repositorioMovil);
        HashMap<Boolean, HashMap> errores = validadorDespliegue.validarDespliegue(idIntervencion, idDespliegueMovil, bomberos);
        int total = bomberos.size();
        int contador = 0;

        try {
            if (errores.containsKey(false)) {
                respuesta.crearRespuestaAccion(ServicioDespliegueBomberos.class, Accion.AGREGAR, false, errores);
            } else {
                for (Integer idBombero : bomberos) {
                    DespliegueBombero nvoDespliegue = new DespliegueBombero();
                    nvoDespliegue.setTicket(repositoriointervencion.findById(idIntervencion).get().getTicket());
                    nvoDespliegue.setIdBombero(idBombero);
                    nvoDespliegue.setIdDespliegueMovil(idDespliegueMovil);
                    nvoDespliegue.setIdIntervencion(idIntervencion);
                    repositorioDespliegueBombero.save(nvoDespliegue);
                    contador++;
                }
                if (total < contador) {
                    HashMap<Boolean, HashMap> error = new HashMap();
                    HashMap<String, Boolean> mapaErrores = new HashMap<>();
                    mapaErrores.put("Se guardaron " + contador + "/" + total + " Bomberos", false);
                    error.put(false, mapaErrores);
                    respuesta.crearRespuestaAccion(ServicioDespliegueBomberos.class, Accion.AGREGAR, false, error);
                } else {
                    respuesta.crearRespuestaAccion(ServicioDespliegueBomberos.class, Accion.AGREGAR, true, null);
                }
            }

        } catch (Exception e) {
            System.out.println("paso un error " + e.getMessage());
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }
}
