package com.SIREB.validadores;

import com.SIREB.modelos.Intervencion;
import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioDespliegueBombero;
import com.SIREB.repositorios.RepositorioDespliegueMovil;
import com.SIREB.repositorios.RepositorioEstado;
import com.SIREB.repositorios.RepositorioIntervencion;
import com.SIREB.repositorios.RepositorioMovil;
import com.SIREB.repositorios.RepositorioTipoAviso;
import com.SIREB.repositorios.RepositorioTipoIntervencion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.stereotype.Component;

/**
 * esta clase es responsble de validar los datos de intervencion
 *
 * @author Marcelo Llanes
 */
@Component
public class ValidadorIntervencion {

    //mapa de errores interno, va en el mapa de errores
    private HashMap<String, Boolean> listaErrores = new HashMap<>();
    //mapa de errores a devolver
    private HashMap<Boolean, HashMap> errores = new HashMap<>();
    private RepositorioDespliegueBombero repositorioDespliegueBombero;
    private RepositorioDespliegueMovil repositorioDespliegueMovil;
    private RepositorioTipoAviso repositorioTipoAviso;
    private RepositorioEstado repositorioEstado;
    private RepositorioBarrioZona repositorioBarrioZona;
    private RepositorioBombero repositorioBombero;
    private RepositorioTipoIntervencion repositorioTipoIntervencion;
    private RepositorioMovil repositorioMovil;
    private RepositorioIntervencion repositorioIntervencion;

    public ValidadorIntervencion(RepositorioDespliegueBombero repositorioDespliegueBombero,
            RepositorioDespliegueMovil repositorioDespliegueMovil, RepositorioTipoAviso repositorioTipoAviso,
            RepositorioEstado repositorioEstado, RepositorioBarrioZona repositorioBarrioZona,
            RepositorioBombero repositorioBombero, RepositorioTipoIntervencion repositorioTipoIntervencion,
            RepositorioMovil repositorioMovil, RepositorioIntervencion repositorioIntervencion) {
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

    /**
     * Este metodo valida un objeto intervencion para ser guardado
     *
     * @param intervencion la intervencion a validar
     * @return un mapa con llave true si es validado y false en caso contrario
     */
    public HashMap<Boolean, HashMap> validarIntervencion(Intervencion intervencion) {

        validarTicket(intervencion.getTicket());
        validarFecha(intervencion.getFecha(), intervencion.getHoraInicio(),
                intervencion.getHoraFin(), intervencion.getHoraLlamado());
        validarDireccion1(intervencion.getDireccion1());
        validarDireccion2(intervencion.getDireccion2());
        validarIdTipoAviso(intervencion.getIdTipoAviso());
        validarIdEstado(intervencion.getIdEstado());
        validarIdBarrioZona(intervencion.getIdBarrioZona());
        validarIdJefeBrigada(intervencion.getIdJefeBrigada());
        validarIdTipoIntervencion(intervencion.getIdTipoIntervencion());
        validarIdMovilRespuesta(intervencion.getIdMovilRespuesta());
        if (listaErrores.containsValue(false)) {
            errores.put(false, listaErrores);
        } else {
            errores.put(true, listaErrores);
        }
        return errores;
    }
    /**
     * este metodo realiza una validacion de actualizacion de una intervencion
     * @param intervencion la intervencion con datos nuevos
     * @param id el id de la intervencion a actualizar
     * @return mapa de errores
     */
    public HashMap<Boolean, HashMap> validarIntervencion(Intervencion intervencion, Integer id) {
        validarDireccion1(intervencion.getDireccion1());
        validarDireccion2(intervencion.getDireccion2());
        validarIdTipoAviso(intervencion.getIdTipoAviso());
        validarIdBarrioZona(intervencion.getIdBarrioZona());
        validarIdJefeBrigada(intervencion.getIdJefeBrigada());
        validarIdTipoIntervencion(intervencion.getIdTipoIntervencion());
        validarIdMovilRespuesta(intervencion.getIdMovilRespuesta());
        validarIdIntervencion(id);
        if (listaErrores.containsValue(false)) {
            errores.put(false, listaErrores);
        } else {
            errores.put(true, listaErrores);
        }
        return errores;
    }

    /**
     * este metodo valida un ticket
     *
     * @param ticket
     * @return mapa de errores
     */
    public HashMap<Boolean, HashMap> validaTicket(String ticket) {
        if (ticket.isBlank() || ticket == null) {
            listaErrores.put("Debe ingresar un numero de ticket valido ", false);
        }
        if (ticket != null && ticket.length() <= 6) {
            listaErrores.put(("El ticket ingresado no es valido"), false);
        }
        if (ticket != null && !repositorioIntervencion.existsByTicket(ticket)) {
            listaErrores.put("El ticket ingresado no existe", false);
        }
        if (listaErrores.containsValue(false)) {
            errores.put(false, listaErrores);
        } else {
            errores.put(true, listaErrores);
        }
        return errores;
    }
    
    public HashMap<Boolean,HashMap> validarId(Integer id){
        validarIdIntervencion(id);
        if (listaErrores.containsValue(false)) {
            errores.put(false, listaErrores);
        } else {
            errores.put(true, listaErrores);
        }
        return errores;
    }

    /**
     * este metodo valida un id de intervencion
     *
     * @param id
     * @return un mapa de errores
     */
    private void validarIdIntervencion(Integer id) {
        if (id < 0) {
            listaErrores.put("El id no puede ser menor a 0", false);
        }
        if (!repositorioIntervencion.existsById(id)) {
            listaErrores.put("El id " +id + " de intervencion no existe", false);
        }
    }

    private void validarTicket(String ticket) {
        if (ticket != null) {
            listaErrores.put("No puede generar un numero de ticket", false);
        }
    }

    private void validarFecha(LocalDate fecha, LocalDateTime horaInicio, LocalDateTime horaFin, LocalDateTime horaLlamado) {
         LocalDate hoy =LocalDate.now();
         LocalDateTime ahora = LocalDateTime.now();
        if (fecha != null) {
            if (fecha.getClass() != LocalDate.class) {
                listaErrores.put("Fecha:Tipo Incorrecto", false);
            }
            if (fecha.isAfter(hoy)) {
                listaErrores.put("Fecha incorrecta,fecha del futuro", false);
            }
        }
        if (horaInicio != null) {
            if (horaInicio.getClass() != LocalDateTime.class) {
                listaErrores.put("Hora de inicio:Tipo Incorrecto", false);
            }
            if (horaInicio.isAfter( ahora)) {
                listaErrores.put("Hora de inicio incorrecta,fecha del futuro", false);
            }
        }
        if (horaFin != null) {
            if (horaFin.getClass() != LocalDateTime.class) {
                listaErrores.put("Hora de fin:Tipo Incorrecto", false);
            }
            if (horaFin.isBefore(horaInicio)) {
                listaErrores.put("Hora de fin incorrecta,no puede finalizar antes de empezar ", false);
            }
            if (horaFin.isAfter(ahora)) {
                listaErrores.put("La hora de finalizacion es incorrecta", false);
            }
        }
        if (horaLlamado != null) {
            if (horaLlamado.isAfter(horaInicio)) {
                listaErrores.put("El llamado no puede hacerse  antes del despacho de unidades", false);
            }
            if (horaLlamado.isAfter(ahora)) {
                listaErrores.put("La llamada no puede predecirse", false);
            }
            if(horaLlamado!= null && horaFin!=null && horaLlamado.isAfter(horaFin) ){
                listaErrores.put("El llamado no puede hacerse despues que finalizo el despacho", false);
            }
        }
    }

    private void validarDireccion1(String direccion) {
        if (direccion.isBlank() || direccion == null) {
            listaErrores.put("Direccion en blanco o nula", false);
        }
        if (!direccion.matches("^[a-zA-ZñÑ0-9 ]+$")) {
            listaErrores.put(" Direccion1 Caracteres invalidos utulizados", false);
        }
    }

    private void validarDireccion2(String direccion) {
        if (direccion != null) {
            if (direccion.isBlank()) {
                listaErrores.put("Direccion en blanco o nula", false);
            }
            if (!direccion.matches("^[a-zA-ZñÑ0-9 ]+$")) {
                listaErrores.put("Direccion2 Caracteres invalidos utilizados", false);
            }
        }
    }

    private void validarIdTipoAviso(Integer idAviso) {
        if (idAviso == null) {
            listaErrores.put("El id de aviso no puede ser nulo", false);
        }
        if (idAviso != null && !repositorioTipoAviso.existsById(idAviso)) {
            listaErrores.put("El id de aviso ingresado no existe", false);
        }
    }

    private void validarIdEstado(Integer idEstado) {
        if (idEstado == null) {
            listaErrores.put("El id de estado no puede ser nulo", false);
        }
        if (idEstado != null && !repositorioEstado.existsById(idEstado)) {
            listaErrores.put("El id de estado ingresado no existe", false);
        }
    }

    private void validarIdBarrioZona(Integer idBarrioZona) {
        if (idBarrioZona == null) {
            listaErrores.put("El id de barrio/zona no puede ser nulo", false);
        }
        if (idBarrioZona != null && !repositorioBarrioZona.existsById(idBarrioZona)) {
            listaErrores.put("El id de Barrio/Zona ingresado no existe", false);
        }
    }

    /*
    No disponible todavia
    private void validarIdModificado() {

    }*/
    private void validarIdJefeBrigada(Integer idJefeBrigada) {
        if (idJefeBrigada == null) {
            listaErrores.put("El id de jefe de brigada no puede ser nulo", false);
        }
        if (idJefeBrigada != null && !repositorioBombero.existsById(idJefeBrigada)) {
            listaErrores.put("El id para jefe de brigada no existe", false);
        }
    }

    private void validarIdTipoIntervencion(Integer idTipoIntervencion) {
        if (idTipoIntervencion == null) {
            listaErrores.put("El id de tipo de intervencion no puede ser nulo", false);
        }
        if (idTipoIntervencion != null && !repositorioTipoIntervencion.existsById(idTipoIntervencion)) {
            listaErrores.put("El id para Tipo de intervencion ingresado no existe", false);
        }
    }

    private void validarIdMovilRespuesta(Integer idMovil) {
        if (idMovil == null) {
            listaErrores.put("El id de movil no puede ser nulo", false);
        }
        if (idMovil != null && !repositorioMovil.existsById(idMovil)) {
            listaErrores.put("El id de movil ingresado no existe", false);
        }
    }
}
