package com.SIREB.servicios;

import com.SIREB.modelos.RespuestaAccion;
import com.SIREB.modelos.enums.Accion;
import java.util.Date;
import java.util.HashMap;

/**
 * Este servicio es el encargado de generar una RespuestaAccion que sera enviada
 * a traves del servicio al controlador, tiene como finalidad proporcionar
 * información , si las acciones solicitadas por el usuario fueron ejecutadas o
 * no, ademas de contener información adicional
 *
 * @author Marcelo Llanes
 */
public class ServicioRespuestaAccion {

    private RespuestaAccion respuesta = new RespuestaAccion();

    /**
     * Devuelve una respuesta a una acción
     *
     * @return una respuesta
     */
    public RespuestaAccion devolverRespuesta() {
        return respuesta;
    }

    /**
     * crear una respuesta
     *
     * @param modulo la clase involucrada
     * @param accion la accion a ejecutar por el usuario
     * @param resultado el resultado de la accion ejecutada
     */
    public void crearRespuestaAccion(Class modulo, Accion accion, boolean resultado, HashMap errores) {
        setFecha();
        setNombreModulo(modulo);
        setTipoAccion(accion.getActual());
        setResultado(resultado);
        setErrores(errores);

    }

    /**
     * setea la fecha de una respuesta al momento de su creacion
     */
    private void setFecha() {
        respuesta.setFecha(new Date());
    }

    /**
     * obtiene un nombre de modulo
     *
     * @param modulo la clase a partir de la cual se obtiene el nombre
     */
    private void setNombreModulo(Class modulo) {
        respuesta.setModulo(modulo.getSimpleName());
    }

    /**
     * devuelve el nombre de modulo de la respuesta
     *
     * @return nombre de modulo
     */
    public String getNombreModulo() {
        return respuesta.getModulo();
    }

    /**
     * el tipo de acción ejecutado por el usuario
     *
     * @param Accion la accion a ejecutar
     */
    private void setTipoAccion(String accion) {
        respuesta.setTipo(accion);
    }

    /**
     * devuelve el tipo de accion guardado en la respuesta
     *
     * @return
     */
    public String getTipoAccion() {
        return respuesta.getTipo();
    }

    /**
     * setea el resultado de una accion ejecutada por el usuario
     *
     * @param resultado
     */
    private void setResultado(boolean resultado) {
        respuesta.setResultado(resultado);
    }

    /**
     * devuelve el resultado de una accion ejecutada por el usuario
     *
     * @return true si la accion fue ejecutada, false en caso contrario;
     */
    public boolean getResultado() {
        return respuesta.isResultado();
    }

    private void setErrores(HashMap errores) {
        String lista;
        if (errores != null) {
            if (errores.containsKey(false)) {
                HashMap listaErrores = (HashMap<String, Boolean>) errores.get(false);
                lista = listaErrores.keySet().toString();
                lista = lista.substring(1, lista.length() - 1);
                respuesta.setMapaErrores(lista);
            }
        }
    }
}
