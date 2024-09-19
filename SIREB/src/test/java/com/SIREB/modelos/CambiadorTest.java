package com.SIREB.modelos;

import com.SIREB.validadores.Cambiador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marcelo Llanes
 */
public class CambiadorTest {

  @Test
  public void cambiadorTestBombero() {
    System.out.println("\nIniciando prueba cambiador Bombero");
    Bombero bombero = new Bombero();
    bombero.setNombre1("MARCELO");
    bombero.setNombre2(null);
    bombero.setApellido("lLaNeS");
    bombero.setDireccion("MaraÑon 545");
    System.out.println("Datos\nnombre :" + bombero.getNombre1());
    System.out.println("segundo nombre :" + bombero.getNombre2());
    System.out.println("Apellido :" + bombero.getApellido());
    System.out.println("direccion :" + bombero.getDireccion());
    Cambiador.paseMayuscula(bombero);
    assertEquals("Marcelo", bombero.getNombre1());
    assertEquals(null, bombero.getNombre2());
    assertEquals("Llanes", bombero.getApellido());
    assertEquals("Marañon 545", bombero.getDireccion());
    System.out.println("DAtos cambiados \n");
    System.out.println("Datos\n nombre :" + bombero.getNombre1());
    System.out.println("segundo nombre :" + bombero.getNombre2());
    System.out.println("Apellido :" + bombero.getApellido());
    System.out.println("direccion :" + bombero.getDireccion());
  }

  @Test
  public void cambiadorTestGrado() {
    System.out.println("\nIniciando prueba cambiador Grado");
    Grado grado = new Grado();
    grado.setGrado("ayudaNTE");
    System.out.println("Nombre de grado " + grado.getGrado());
    Cambiador.paseMayuscula(grado);
    assertEquals("Ayudante", grado.getGrado());
    System.out.println("Nombre cambiado a " + grado.getGrado());
  }

  @Test
  public void cambiadorTestCuartel() {
    System.out.println("\nIniciando prueba cambiador Cuartel");
    Cuartel cuartel = new Cuartel();
    cuartel.setDireccion("sarMiento 765");
    System.out.println("Direccion de cuartel: " + cuartel.getDireccion());
    Cambiador.paseMayuscula(cuartel);
    assertEquals("Sarmiento 765", cuartel.getDireccion());
    System.out.println("Direccion cambiada a " + cuartel.getDireccion());
  }

  @Test
  public void cambiadorTestBarrioZona() {
    System.out.println("\nIniciando prueba cambiador BarrioZona");
    BarrioZona barriZona = new BarrioZona();
    barriZona.setBarrioZona("atanoR");
    System.out.println("Barrio o Zona: " + barriZona.getBarrioZona());
    Cambiador.paseMayuscula(barriZona);
    assertEquals("Atanor", barriZona.getBarrioZona());
    System.out.println("Barrio o Zona  cambiada a " + barriZona.getBarrioZona());
  }

  @Test
  public void cambiadorTestMotivoBaja() {
    System.out.println("\nIniciando prueba cambiador OtrosServicios ");
    MotivoBaja baja = new MotivoBaja(1, "baja por incumplimiento", "incumplimiento en deberes eticos");
    System.out.println("Motivo de Baja:  " + baja.getMotivo() + " Descripcion: " + baja.getDescripcion());
    Cambiador.paseMayuscula(baja);
    assertEquals("Baja por incumplimiento", baja.getMotivo());
    System.out.println("Incumplimiento en deberes eticos " + baja.getDescripcion());

  }

  @Test
  public void cambiadorTestOtrosServicios() {
    System.out.println("\nIniciado prueba cambiador OtrosServicios");
    OtrosServicios servicio = new OtrosServicios();
    servicio.setServicio("uniDad k9");
    servicio.setDescripcion("unidad Canina");
    System.out.println("OtroServicio servicio :" + servicio.getServicio() + "\nDescripcion " + servicio.getDescripcion());

    Cambiador.paseMayuscula(servicio);
    assertEquals("Unidad K9", servicio.getServicio());
    assertEquals("Unidad canina", servicio.getDescripcion());
    System.out.println("OtroServicio servicio :" + servicio.getServicio() + "\nDescripcion " + servicio.getDescripcion());
  }

  @Test
  public void cambiadorTestMovil() {
    System.out.println("\nIniciado prueba cambiador OtrosServicios");
    Movil movil = new Movil();
    movil.setMarca("bmw");
    movil.setModelo("learJet 500");
    System.out.println("Movil marca :" + movil.getMarca() + "\nmodelo " + movil.getModelo());
    Cambiador.paseMayuscula(movil);
    assertEquals("BMW", movil.getMarca());
    assertEquals("Learjet 500", movil.getModelo());
    System.out.println("Movil cambiado marca :" + movil.getMarca() + "\nmodelo " + movil.getModelo());
  }

  @Test
  public void cambiadorTestOtro() {
    System.out.println("\nIniciando prueba cambiador en UsuarioContraseña");
    UsuarioContraseña usuario = new UsuarioContraseña("usuArio", "CONTRASEÑA");
    System.out.println("Usuario: " + usuario.getUsuario() + " contraseña " + usuario.getContraseña());
    Cambiador.paseMayuscula(usuario);
    assertEquals("usuArio", usuario.getUsuario());
    assertEquals("CONTRASEÑA", usuario.getContraseña());
    System.out.println("valores sin cambiar usuario: " + usuario.getUsuario() + "\ncontraseña: " + usuario.getContraseña());
  }

  @Test
  public void cambiadorTestNull() {
    System.out.println("\nIniciando prueba con un objeto nulo");
    Bombero bombero = null;
    Cambiador.paseMayuscula(bombero);
    assertNull(bombero);
    System.out.println("El objeto no ha cambiado " + bombero);
  }
  
  @Test
  public void cambiadorTestInteger(){
    System.out.println("\nIniciando pruebas con un Integer como objeto");
    Cambiador.paseMayuscula(35);
    System.out.println("el numero 35 recibido como argumento no produjo cambios");
  }
  
  @Test
  public void cambiadorTestChar(){
    System.out.println("\nIniciando pruebas con un char como objeto");
    Cambiador.paseMayuscula('a');
    System.out.println("el caracter 'a' recibido como argumento no produjo cambios");
  }
  
  @Test
  public void cambiadorTestOtroObjeto(){
    System.out.println("\nIniciando pruebas con objeto Ticket");
    Cuartel ticket = new Cuartel();
    Cambiador.paseMayuscula(ticket);
    System.out.println(ticket.getDireccion());
    System.out.println("el objeto ticket recibido como argumento no produjo cambios");
  }
  @Test
  public void cambiadorTestCampoNulo(){
    System.out.println("\nIniciando pruebas con objeto con campo nulo");
    Cambiador.paseMayuscula(null);
    System.out.println("El objeto " + null +" no genero error");
  }
  @Test
  public void cambiadorCompleto(){
    System.out.println("\nIniciando pruebas con objeto con campo nulo en objeto Bombero");
    Bombero bombero = new Bombero();
    bombero.setNombre1("marcelO");
    bombero.setNombre2(null);
    bombero.setApellido("llaNES");
    bombero.setDireccion("Rio MagdalENA 545");
    Cambiador.paseMayuscula(bombero);
    assertEquals("Marcelo", bombero.getNombre1());
    assertEquals(null, bombero.getNombre2());
    assertEquals("Llanes", bombero.getApellido());
    assertEquals("Rio Magdalena 545", bombero.getDireccion());
    System.out.println("prueba finalizada nombre: " + bombero.getNombre1() + " nombre2: " + bombero.getNombre2() + " apellido: " + bombero.getApellido()
    + " direccion: " + bombero.getDireccion());
  }
  @Test
   public void CambiadorTexto(){
    String texto= "hola soy un texto";
    Cambiador.paseMayuscula(texto);
    System.out.println(texto);
  }
}
