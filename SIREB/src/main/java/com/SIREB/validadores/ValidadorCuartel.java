/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SIREB.validadores;

import com.SIREB.modelos.Cuartel;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kike
 */
@Component
public class ValidadorCuartel {

    private HashMap<String, Boolean> listaErrores = new HashMap<>();
    //mapa de errores a devolver
    private HashMap<Boolean, HashMap> errores = new HashMap<>();
    
    public HashMap<Boolean, HashMap> validarCuartel(Cuartel cuartel){
        errores.clear();
        listaErrores.clear();
        errores.put(true, listaErrores);
        return errores;
    }
}
