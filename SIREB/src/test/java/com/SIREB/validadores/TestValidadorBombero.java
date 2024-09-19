package com.SIREB.validadores;

import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.Grado;
import com.SIREB.modelos.MotivoBaja;
import com.SIREB.modelos.enums.FactorSanguineo;
import com.SIREB.modelos.enums.Genero;
import com.SIREB.repositorios.RepositorioMotivoBaja;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioCuartel;
import com.SIREB.repositorios.RepositorioGrado;
import com.SIREB.servicios.ServicioCuartel;
import com.SIREB.servicios.ServicioGrado;
import com.SIREB.servicios.ServicioMotivoBaja;
import com.SIREB.servicios.ServicioSesion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class TestValidadorBombero {

    private ValidadorBombero validador;

/**
 Creamos los tres servicios apuntando a un mock.
 * Creamos el validadorBombero pasando por referencia
 * los tres mocks.
 */

@Test
public void bomberoInvalidoTest() throws ParseException{
    
    RepositorioCuartel repositorioCuartelMock = Mockito.mock(RepositorioCuartel.class);
    RepositorioGrado repositorioGrado = Mockito.mock(RepositorioGrado.class);
    RepositorioMotivoBaja repositorioMotivoBaja = Mockito.mock(RepositorioMotivoBaja.class);
    RepositorioBombero repositorioBombero = Mockito.mock(RepositorioBombero.class);
    
    
    //creo el validador.
    validador = new ValidadorBombero(repositorioCuartelMock,repositorioGrado,
                repositorioMotivoBaja,repositorioBombero);
    
    //defino las respuestas de cada objeto cuando se los llame.
        
    Mockito.when(repositorioCuartelMock.existsById(1)).thenReturn(null);
    
    
    Grado grado = new Grado();
    grado.setIdGrado(1);
    grado.setGrado("Coronel");
    
    Mockito.when(repositorioGrado.existeGrado("Sargento")).thenReturn(2);//repondo con un codigo 200,
    //en el cuerpo del objeto el grado]


        //creo el validador.
        validador = new ValidadorBombero(repositorioCuartelMock,repositorioGrado,
                repositorioMotivoBaja,repositorioBombero);
        //defino las respuestas de cada objeto cuando se los llame.
        Mockito.when(repositorioCuartelMock.existsById(1)).thenReturn(null);
        Mockito.when(repositorioMotivoBaja.existsById(1)).thenReturn(null);
        Mockito.when(repositorioGrado.existsById(1)).thenReturn(false);

        Bombero bombero = crearBombero();
        bombero.setNombre1("Bombero1");
        bombero.setNombre2("   ");
        bombero.setApellido(null);
        bombero.setDireccion("utgg 123!");
        bombero.setFactorSanguineo("ABPOSsssssss");
        bombero.setDNI("3589459358960543892");
        bombero.setEdad(-15); 
        bombero.setTelefonoCasa(null);
        bombero.setTelefonoCelular("3571");
        bombero.setGenero("otro");
        String sDate1="31/12/2023";  
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        bombero.setFechaNacimiento(date1);
        String sDate2="17/04/2024";  
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2); 
        bombero.setFechaAlta(date2);
        String sDate3="17/04/2222"; 
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3); 
        bombero.setFechaBaja(date3);

        HashMap <Boolean,HashMap>valido = validador.validarBombero(bombero);

        /*assertFalse(valido.get("Nombre1"));// el nombre es invalido 
        assertFalse(valido.get("Nombre2"));//nombre  es invalido
        assertFalse(valido.get("Apellido"));//apellido es invalido 
        assertFalse(valido.get("DNI")); 
        assertFalse(valido.get("Direccion"));
        assertFalse(valido.get("Edad"));  
        assertFalse(valido.get("TelefonoCasa"));
        assertFalse(valido.get("TelefonoCelular"));
        assertFalse(valido.get("Genero"));
        assertFalse(valido.get("FechaNacimiento"));
        assertFalse(valido.get("FechaAlta"));
        assertFalse(valido.get("FechaBaja"));*/

    }

    /**
     Creamos los tres servicios apuntando a un mock.
     * Creamos el validadorBombero pasando por referencia
     * los tres mocks.
     */
   
@Test
public void idCuartelInvalidoTest() {
        
        RepositorioCuartel repositorioCuartelMock = Mockito.mock(RepositorioCuartel.class);
        RepositorioGrado repositorioGrado = Mockito.mock(RepositorioGrado.class);
        RepositorioMotivoBaja repositorioMotivoBaja = Mockito.mock(RepositorioMotivoBaja.class);
        RepositorioBombero repositorioBombero = Mockito.mock(RepositorioBombero.class);
        
        

        //creo el validador.
       validador = new ValidadorBombero(repositorioCuartelMock,repositorioGrado,
                repositorioMotivoBaja,repositorioBombero);
        
        


        //defino las respuestas de cada objeto cuando se los llame.
        MotivoBaja motivoBaja = new MotivoBaja(2,"Por burro", "No cumplio las espectativas");

        Mockito.when(repositorioCuartelMock.existsById(1)).thenReturn(null);
        Mockito.when(repositorioMotivoBaja.existsById(1)).thenReturn(false);

        Grado grado = new Grado();
        grado.setIdGrado(1);
        grado.setGrado("Coronel");

       // Mockito.when(repositorioGrado.findById(1)).thenReturn(ResponseEntity.ok().body(true));//repondo con un codigo 200,
        //en el cuerpo del objeto el grado]

        Bombero bombero = crearBombero();//creo el bombero a validar.
        bombero.setIdCuartel(1);   

        HashMap <Boolean, HashMap>valido = validador.validarBombero(bombero);//valido el bombero

        //verifica que haya sido llamado al menos una vez
        Mockito.verify(repositorioCuartelMock).existsById(1);

        

    }

    private Bombero crearBombero(){
        Bombero bombero = new Bombero();
        bombero.setNombre1("Florinda");
        bombero.setNombre2("Nieves");
        bombero.setApellido("Meza");
        bombero.setDireccion("San Martin 123");
        bombero.setDNI("35674893");
        bombero.setTelefonoCasa("3571123456");
        bombero.setTelefonoCelular("3457123432");
        bombero.setFactorSanguineo(FactorSanguineo.ONEG.toString());
        bombero.setGenero(Genero.FEMENINO.toString());
        bombero.setEdad(19);
        bombero.setIdMotivoBaja(1);
        bombero.setIdGrado(1);
        bombero.setIdCuartel(1);
        bombero.setFechaNacimiento(new Date());
        bombero.setFechaAlta(new Date());
        bombero.setFechaBaja(new Date());

        return bombero;
    }
}







