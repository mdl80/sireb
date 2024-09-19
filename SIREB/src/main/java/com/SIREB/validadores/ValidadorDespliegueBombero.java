package com.SIREB.validadores;

import com.SIREB.modelos.DespliegueBombero;
import com.SIREB.modelos.DespliegueMovil;
import com.SIREB.modelos.Movil;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioDespliegueBombero;
import com.SIREB.repositorios.RepositorioDespliegueMovil;
import com.SIREB.repositorios.RepositorioIntervencion;
import com.SIREB.repositorios.RepositorioMovil;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * esta clase es responsable de la validación de un despliegue de bomberos
 *
 * @author marcelo
 */
@Service
public class ValidadorDespliegueBombero {

    HashMap<String, Boolean> listaErrores = new HashMap<>();
    HashMap<Boolean, HashMap> errores = new HashMap<>();

    RepositorioIntervencion repositorioIntervencion;
    RepositorioBombero repositorioBombero;
    RepositorioDespliegueMovil repositorioDespliegueMovil;
    RepositorioDespliegueBombero repositorioDespliegueBombero;
    RepositorioMovil repositorioMovil;

    @Autowired
    public ValidadorDespliegueBombero(RepositorioIntervencion repositorioIntervencion, RepositorioBombero repositorioBombero,
            RepositorioDespliegueMovil repositorioDespliegueMovil, RepositorioDespliegueBombero repositorioDespliegueBombero, RepositorioMovil repositorioMovil) {
        this.repositorioIntervencion = repositorioIntervencion;
        this.repositorioBombero = repositorioBombero;
        this.repositorioDespliegueMovil = repositorioDespliegueMovil;
        this.repositorioDespliegueBombero = repositorioDespliegueBombero;
        this.repositorioMovil = repositorioMovil;
    }

    /**
     * este metodo valida un despliegue de bombero
     *
     * @param despliegueBombero
     * @return un mapa de errrores
     * @deprecated este metodo ha sido reemplazado por un metodo del mismo
     * nombre, ya no es necesario recibir un objeto de tipo DespliegueBombero,
     * solo introducir, un id de intervencion,id de despliegue de movil y una
     * lista de bomberos desplegados
     */
    @Deprecated
    public HashMap<Boolean, HashMap> validarDespliegue(DespliegueBombero despliegueBombero) {
        validaTicket(despliegueBombero.getTicket());
        validarIdBombero(despliegueBombero.getIdBombero());
        validarIdIntervencion(despliegueBombero.getIdIntervencion());
        validarIdDespliegueMovil(despliegueBombero.getIdDespliegueMovil());
        return listaErrores.containsValue(false) ? errores.put(false, listaErrores) : errores.put(true, listaErrores);
    }

    /**
     * este metodo reemplazada al metodo obsoleto validarDespliegue
     *
     * @param idIntervencion el id de intervencion donde se realizara el
     * despliegue
     * @param idDespliegueMovil el id de despliegue de movil este parametro
     * puede ser nulo
     * @param bomberos una lista de bomberos a desplegar
     * @return un mapa de errores
     */
    public HashMap<Boolean, HashMap> validarDespliegue(Integer idIntervencion, Integer idDespliegueMovil, List<Integer> bomberos) {

        List<DespliegueBombero> listaDesplegados = null;
        
        validarIdDespliegueMovil(idDespliegueMovil);
        validarIdIntervencion(idIntervencion);
        try {
            

            if (!listaErrores.containsValue(false)) {
                if (repositorioDespliegueBombero.existsByIdIntervencionAndIdDespliegueMovil(idIntervencion, idDespliegueMovil)) {
                    listaDesplegados = repositorioDespliegueBombero.findAllByIdIntervencionAndIdDespliegueMovil(idIntervencion, idDespliegueMovil);
                    for (Integer idBombero : bomberos) {
                        DespliegueBombero nvoDespliegueBombero = nvoDespliegue(idIntervencion, idBombero, idDespliegueMovil);
                        for (DespliegueBombero desplegado : listaDesplegados) {
                            if (nvoDespliegueBombero.equals(desplegado)) {
                                listaErrores.put("El id " + idBombero + " ya  encuentra desplegado", false);
                            }
                        }
                    }
                }
            }

            if (listaErrores.containsValue(false)) {
                errores.put(false, listaErrores);
            } else {
                errores.put(true, listaErrores);
            }

        } catch (Exception e) {

        }

        return errores;
    }

    private void validaTicket(String ticket) {
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
    }

    private void validarIdBombero(Integer id) {
        if (id == null) {
            listaErrores.put("id Nulo", false);
        }
        if (id < 0) {
            listaErrores.put("El id es menor a 0", false);
        }
        if (!repositorioBombero.existsById(id)) {
            listaErrores.put("El id " + id + " no existe", false);
        }
    }

    private void validarIdIntervencion(Integer id) {
        if (id < 0) {
            listaErrores.put("El id no puede ser menor a 0", false);
        }
        if (!repositorioIntervencion.existsById(id)) {
            listaErrores.put("El id de intervencion no existe", false);
        }
    }

    private void validarIdDespliegueMovil(Integer idDespliegueMovil) {
        if (idDespliegueMovil != null) {
            if (idDespliegueMovil < 0) {
                listaErrores.put("El id de Despliegue de movil no puede ser menor a 0", false);
            }
            if (!repositorioDespliegueMovil.existsById(idDespliegueMovil)) {
                listaErrores.put("El id de Despliegue de movil no existe", false);
            }
        }
    }

    private Boolean validarPlazas(Integer cantidad, Integer idDespliegueMovil) {
        int idMovil;
        int plaza;
        Movil movil;
        boolean validado = false;
        if (repositorioDespliegueMovil.existsById(idDespliegueMovil)) {
            DespliegueMovil movilDesplegado = repositorioDespliegueMovil.findById(idDespliegueMovil).get();
            idMovil = movilDesplegado.getIdMovil();
            movil = repositorioMovil.findById(idMovil).get();
            plaza = movil.getPlaza();

            if (cantidad >= plaza) {
                listaErrores.put("la cantidad de bomberos desplegados supera la plaza del movil " + movil.getNumeroMovil(), false);
            } else {
                validado = true;
            }
        }
        return validado;
    }

    private DespliegueBombero nvoDespliegue(Integer idIntervencion, Integer idBombero, Integer idDespliegueMovil) {
        DespliegueBombero nvoDespliegueBombero = new DespliegueBombero();

        nvoDespliegueBombero.setTicket(repositorioIntervencion.findById(idIntervencion).get().getTicket());
        nvoDespliegueBombero.setIdBombero(idBombero);
        nvoDespliegueBombero.setIdDespliegueMovil(idDespliegueMovil);
        nvoDespliegueBombero.setIdIntervencion(idIntervencion);
        return nvoDespliegueBombero;
    }
}
