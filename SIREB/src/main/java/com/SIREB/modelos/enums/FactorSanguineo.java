package com.SIREB.modelos.enums;


/**
 * esta clase determina los distintos factores sanguineros RH
 * que puede tener una persona
 * @author Marcelo Llanes
 */
public enum FactorSanguineo {
    APOS("A+"),
    ANEG("A-"),
    BPOS("B+"),
    BNEG("B-"),
    ABPOS("AB+"),
    ABNEG("AB-"),
    OPOS("0+"),
    ONEG("0-");

    private final String value;
    
    FactorSanguineo(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
   
}

