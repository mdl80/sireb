package com.SIREB.validadores;

import com.SIREB.repositorios.RepositorioEstado;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marcelo
 */
public class ValidadorEstado {

    private RepositorioEstado repositorioEstado;
    HashMap<String, Boolean> listaErrores = new HashMap<>();
    HashMap<Boolean, HashMap> errores = new HashMap<>();

    @Autowired
    public ValidadorEstado(RepositorioEstado repositorioEstado) {
        this.repositorioEstado = repositorioEstado;
    }

    public HashMap<Boolean, HashMap> validarId(Integer idEstado) {
        validar(idEstado);
        if (listaErrores.containsValue(false)) {
            errores.put(false, listaErrores);
        } else {
            errores.put(true, listaErrores);
        }
        return errores;
    }

    private void validar(Integer IdEstado) {
        if (IdEstado != null) {
            if (!repositorioEstado.existsById(IdEstado)) {
                listaErrores.put("El id " + IdEstado + " no existe", false);
            }
        }
    }

}
