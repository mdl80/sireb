package com.SIREB.modelos.enums;


public enum Grado {
    
    COMANDANTEGENERAL("Comandante General"),
    COMANDANTEMAYOR("Comandante Mayor"),
    COMANDANTE("Comandante"),
    SUBCOMANDANTE("Sub Comandante"),
    OFICIALPRINCIPAL("Oficial Principal"),
    OFICIALINSPECTOR("Oficial Inspector"),
    OFICIALAYUDANTE("Oficial Ayudante"),
    SUBOFICIALMAYOR("Suboficial Mayor"),
    SUBOFICIALPRINCIPAL("Suboficial Principal"),
    SARGENTOPRIMERO("Sargento Primero"),
    SARGENTO("Sargento"),
    CABOPRIMERO("Cabo Primero"),
    CABO("Cabo");
    
      private String value;
        Grado(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
