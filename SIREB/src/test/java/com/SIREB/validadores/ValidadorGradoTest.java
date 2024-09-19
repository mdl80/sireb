package com.SIREB.validadores;

import com.SIREB.modelos.Grado;
import com.SIREB.repositorios.RepositorioGrado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * test para el validador de la clase grado
 *
 * @author Marcelo Llanes
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidadorGradoTest {


    RepositorioGrado repositorio = Mockito.mock(RepositorioGrado.class);
    ValidadorGrado validador = new ValidadorGrado(repositorio);
  

  @AfterEach
  public void tearDown() {
  }

  /**
   * Prueba positiva , se ingresa un grado on el valor "Teniente Primero",
   * cumple todas las condiciones de validacion
   */
  @Test
  public void testValidarGradoPositivo() {
    System.out.println("Pruebas positivas validarGrado");
    Grado grado = new Grado();
    grado.setGrado("Teniente primero");
    System.out.println("Nombre de Grado " + grado.getGrado());
    Boolean expResult = true;
    System.out.println("el validador tiene: " + validador.validarGrado(grado).containsKey(true));
    Boolean result = validador.validarGrado(grado).containsKey(true);
    assertEquals(expResult, result);

  }

  /**
   * prueba Negativa , grado es igual a null
   */
  @Test
  public void testValidarGradoNulo() {
    System.out.println("\nPrueba Negativa validar Grado nulo");
    Grado grado = null;
    System.out.println("Valor de grado = null");
    //se espera un resultado false
    Boolean expResult = false;
    Boolean result = validador.validarGrado(grado).containsKey(true);
    assertEquals(expResult, result);
  }

  /**
   * prueba negativa , se espera que no valide un nombre del tipo ""," "
   */
  @Test
  public void testValidarNombreGrado() {
    System.out.println("\nPrueba Negativa validar Grado en blanco o con espacios en blanco");
    Grado grado1 = new Grado();
    grado1.setGrado("");
    Grado grado2 = new Grado();
    grado2.setGrado("     ");
    System.out.println("grado1:" + grado1.getGrado() + "\tgrado2:" + grado2.getGrado());
    Boolean expResult = false;
    Boolean result = validador.validarGrado(grado1).containsKey(true);
    assertEquals(expResult, result);
    result = validador.validarGrado(grado2).containsKey(true);
    assertEquals(expResult, result);
  }

  /**
   * Prueba negativa con longitud de nombre menor a 4 el rango mas corto es cabo
   */
  @Test

  public void testValidarLongitudNombreGrado() {
    System.out.println("\nPrueba Negativa validar Longitud nombre Grado");
    Grado grado = new Grado();
    grado.setGrado("san");
    System.out.println("grado:" + grado.getGrado());
    Boolean expResult = false;
    Boolean result = validador.validarGrado(grado).containsKey(true);
    assertEquals(expResult, result);
  }

  /**
   * Prueba negativa , nombre de grado con caracteres numericos o especiales
   */
  @ParameterizedTest
  @ValueSource(strings = {"4Mayor","Princip4l","teniente%","12312&"})
  public void testCaracterGrado(String nombreGrado) {
    System.out.println("Prueba negativa con caracteres distintos de letras");
    Grado grado = new Grado();
    grado.setGrado(nombreGrado);
    System.out.println("nombre:" + grado.getGrado() + " " + validador.validarGrado(grado));
   /*
    Boolean expresult = false;
    //se espera que arroje false,
    Boolean result = !validador.validarGrado(grado).containsKey(false);
    assertEquals(expresult, result);*/
    assertFalse(validador.validarGrado(grado).containsKey(true));
  }
  
  /**
   * Prueba positiva , se ingresa un id de grado positivo y existente
   */
  @Test
  public void testValidarIdGradoPositivo() {
    System.out.println("Pruebas positivas validarGrado");
    Integer idGrado = 4; 
    Mockito.when(repositorio.existsById(idGrado)).thenReturn(true);
    //mockeando metodo pivado
    //se espera un resultado false
    System.out.println("id de Grado " + idGrado);
    Boolean expResult = true;
    Boolean result = validador.validarGrado(idGrado).containsKey(true);
    assertEquals(expResult, result);

  }

  /**
   * prueba Negativa , id grado es igual a null
   */

  @Test
  public void testValidarIdGradoNulo() {
    System.out.println("\nPrueba Negativa validar IdGrado nulo");
    Integer idGrado = null;
    System.out.println("Valor de idGrado = null");
    //se espera un resultado false
    Boolean expResult = false;
    Boolean result = validador.validarGrado(idGrado).containsKey(true);
    assertEquals(expResult, result);
  }

  /**
   * prueba Negativa , id grado es menor a 0
   */
  @Test
  public void testValidarIdGradoNegativo() {

    System.out.println("\nPrueba Negativa validar IdGrado nulo");
    Integer idGrado = -2;
    System.out.println("Valor de idGrado = null");
    Boolean expResult = false;
    Boolean result = validador.validarGrado(idGrado).containsKey(true);
    assertEquals(expResult, result);
  }

  /**
   * prueba Negativa , id grado no existe
   */
  @Test
  public void testValidarIdGradoInexistente() {
    System.out.println("\nPrueba Negativa validar IdGrado nulo");
    Integer idGrado = 99;
    System.out.println("Valor de idGrado = null");
    Mockito.when(repositorio.existsById(99)).thenReturn(false);
    //se espera un resultado false
    Boolean expResult = false;
    Boolean result = validador.validarGrado(idGrado).containsKey(true);
    assertEquals(expResult, result);
  }

}
