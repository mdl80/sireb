package com.SIREB.modelos.enums;

/**
 * esta clase determina los generos disponibles para asignar a una persona
 * @author Marcelo Llanes
 */
public enum Genero {
    FEMENINO("F"),
    MASCULINO("M"),
    NODETERM("X");

    private final String value;
    Genero(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
    

