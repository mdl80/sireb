package com.SIREB.servicios;

import com.SIREB.modelos.Intervencion;
import com.SIREB.modelos.Ticket;
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
import com.SIREB.validadores.Cambiador;
import com.SIREB.validadores.ValidadorEstado;
import com.SIREB.validadores.ValidadorIntervencion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * El servicio proporciona la logicade la intervencion
 *
 * @author Marcelo Llanes
 */
@Service
@Slf4j
public class ServicioIntervencion {

    @Autowired
    private RepositorioDespliegueMovil repositorioDespliegueMovil;
    @Autowired
    private RepositorioDespliegueBombero repositorioDespliegueBombero;
    @Autowired
    private RepositorioIntervencion repositorioIntervencion;
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
    private RepositorioMovil repositorioMovil;
    @Autowired
    private ServicioSesion servicioSesion;
    @Autowired
    private ServicioEventos evento;
    private ValidadorEstado validadorEstado;
    private ServicioRespuestaAccion respuesta;

    /**
     * este metodo guarda una intervencion
     *
     * @param intervencion la intervencion a guardar
     * @param token el token de usuario
     * @return una respuesta de guardado
     */
    public ResponseEntity guardarIntervencion(Intervencion intervencion, String token) {
        respuesta = new ServicioRespuestaAccion();
        ValidadorIntervencion validadorIntervencion = new ValidadorIntervencion(repositorioDespliegueBombero, repositorioDespliegueMovil,
                repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero,
                repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        HashMap<Boolean, HashMap> mapaErrores = validadorIntervencion.validarIntervencion(intervencion);

        try {
            if (servicioSesion.Validar(token) && mapaErrores.containsKey(false)) {
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.AGREGAR, false, mapaErrores);
                return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
            }
            if (servicioSesion.Validar(token) && mapaErrores.containsKey(true)) {
                intervencion.setFecha(LocalDate.now());
                intervencion.setHoraInicio(LocalDateTime.now());
                intervencion.setTicket(GeneradorTicket());
                Cambiador.paseMayuscula(intervencion);
                repositorioIntervencion.save(intervencion);
                evento.agregarEvento(evento.nuevoEvento(token, Accion.AGREGAR, intervencion));
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.AGREGAR, true, mapaErrores);
            }
            if (!servicioSesion.Validar(token)) {
                respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
            }

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
        //repositorioIntervencion.save(intervencion);
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

    //en construccion
    public ResponseEntity actualizarIntervencion(Intervencion intervencion, Integer id, String token) {
        respuesta = new ServicioRespuestaAccion();
        ValidadorIntervencion validadorIntervencion = new ValidadorIntervencion(repositorioDespliegueBombero, repositorioDespliegueMovil, repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero, repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        HashMap<Boolean, HashMap> intervencionValidada = validadorIntervencion.validarIntervencion(intervencion, id);

        try {
            if (servicioSesion.Validar(token) && intervencionValidada.containsKey(true)) {
                Intervencion viejaIntervencion = repositorioIntervencion.findById(id).get();
                Intervencion nvaIntervencion = actualizarIntervencion(intervencion, viejaIntervencion);
                Cambiador.paseMayuscula(nvaIntervencion);
                repositorioIntervencion.save(actualizarIntervencion(intervencion, nvaIntervencion));
                evento.agregarEvento(evento.nuevoEvento(token, Accion.ACTUALIZAR, repositorioIntervencion.findById(id).get()));
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.ACTUALIZAR, true, intervencionValidada);
            }
            if (servicioSesion.Validar(token) && intervencionValidada.containsKey(false)) {
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.ACTUALIZAR, false, intervencionValidada);
            }
            if (!servicioSesion.Validar(token)) {
                respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
            }

        } catch (Exception e) {
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

    public ResponseEntity<JSONObject> mostrarTodo(String token, Integer idEstado) {
        respuesta = new ServicioRespuestaAccion();
        validadorEstado = new ValidadorEstado(repositorioEstado);
        HashMap<Boolean,HashMap> errores = validadorEstado.validarId(idEstado);
        
        try {
            if (servicioSesion.Validar(token) && idEstado == null && errores.containsKey(true)) {
                return new ResponseEntity(repositorioIntervencion.findAll(), HttpStatus.OK);
            }
            if (servicioSesion.Validar(token) && idEstado != null && errores.containsKey(true)) {
                if (repositorioIntervencion.existsByIdEstado(idEstado)) {
                    return new ResponseEntity(repositorioIntervencion.findAllByIdEstado(idEstado), HttpStatus.OK);
                }
            }
            if((servicioSesion.Validar(token) && idEstado==null && errores.containsKey(false)) || servicioSesion.Validar(token) && idEstado!=null && errores.containsKey(false)){
                respuesta.crearRespuestaAccion(ServicioIntervencion.class, Accion.MOSTRAR,false, errores);
            }
            if (!servicioSesion.Validar(token)) {
                respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
            }
        } catch (Exception e) {
            return new ResponseEntity("un error paso: " + e.getMessage(),HttpStatus.OK );
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

    public ResponseEntity<Intervencion> buscarPorTicket(String ticket, String token) {
        respuesta = new ServicioRespuestaAccion();
        ValidadorIntervencion validador = new ValidadorIntervencion(repositorioDespliegueBombero, repositorioDespliegueMovil, repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero, repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        HashMap<Boolean, HashMap> ticketValidado = validador.validaTicket(ticket);
        log.info("validado: " + servicioSesion.Validar(token));
        try {
            if (servicioSesion.Validar(token) && ticketValidado.containsKey(true)) {
                return new ResponseEntity(repositorioIntervencion.findByTicket(ticket).get(), HttpStatus.OK);
            }
            if (servicioSesion.Validar(token) && ticketValidado.containsKey(false)) {
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.MOSTRAR, false, ticketValidado);
            }
            if (!servicioSesion.Validar(token)) {
                respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
            }

        } catch (Exception e) {
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

    public ResponseEntity<Intervencion> buscarPorId(Integer id, String token) {
        respuesta = new ServicioRespuestaAccion();
        ValidadorIntervencion validador = new ValidadorIntervencion(repositorioDespliegueBombero, repositorioDespliegueMovil, repositorioTipoAviso, repositorioEstado, repositorioBarrioZona, repositorioBombero, repositorioTipoIntervencion, repositorioMovil, repositorioIntervencion);
        HashMap<Boolean, HashMap> idValidado = validador.validarId(id);
        try {
            if (servicioSesion.Validar(token) && idValidado.containsKey(true)) {
                return new ResponseEntity(repositorioIntervencion.findById(id).get(), HttpStatus.OK);
            }
            if (servicioSesion.Validar(token) && idValidado.containsKey(false)) {
                respuesta.crearRespuestaAccion(Intervencion.class, Accion.MOSTRAR, false, idValidado);
            }
            if (!servicioSesion.Validar(token)) {
                respuesta.crearRespuestaAccion(ServicioSesion.class, Accion.AUTENTICAR, false, null);
            }

        } catch (Exception e) {
        }
        return new ResponseEntity(respuesta.devolverRespuesta(), HttpStatus.OK);
    }

    /**
     * este metodo privado genera un ticket para una intervencion
     *
     * @return un numero de ticket en forma de string
     */
    private String GeneradorTicket() {
        String ticket = new Ticket().getTicket();
        while (repositorioIntervencion.existsByTicket(ticket)) {
            ticket = new Ticket().getTicket();
        }
        return ticket;
    }

    /**
     * devuelve una intervencion con datos actualizados, excepto numero de
     * ticket fecha ,hora de inicio,estado de finalizacion e informe
     *
     * @param intervencion la intervencion con datos nuevos
     * @param nvaIntervencion la intervencion a actualizar;
     * @return intervencion con datos actualizados
     */
    //falta otros servicios
    private Intervencion actualizarIntervencion(Intervencion intervencion, Intervencion nvaIntervencion) {
        try {
            nvaIntervencion.setDireccion1(intervencion.getDireccion1());
            nvaIntervencion.setDireccion2(intervencion.getDireccion2());
            nvaIntervencion.setNombreAlertante(intervencion.getNombreAlertante());
            nvaIntervencion.setApellidoAlertante(intervencion.getApellidoAlertante());
            nvaIntervencion.setContactoAlertante(intervencion.getContactoAlertante());
            nvaIntervencion.setIdBarrioZona(intervencion.getIdBarrioZona());
            nvaIntervencion.setIdIntervencion(intervencion.getIdIntervencion());
            nvaIntervencion.setIdJefeBrigada(intervencion.getIdJefeBrigada());
            nvaIntervencion.setInformeIntervencion(intervencion.getInformeIntervencion());
            nvaIntervencion.setIdMovilRespuesta(intervencion.getIdMovilRespuesta());
            nvaIntervencion.setIdTipoAviso(intervencion.getIdTipoAviso());
            nvaIntervencion.setIdEstado(intervencion.getIdEstado());
            // nvaIntervencion.setHoraInicio(intervencion.getHoraInicio());
            nvaIntervencion.setHoraFin(intervencion.getHoraFin());
            nvaIntervencion.setHoraLlamado(intervencion.getHoraLlamado());
        } catch (Exception e) {
        }
        return nvaIntervencion;
    }
}
