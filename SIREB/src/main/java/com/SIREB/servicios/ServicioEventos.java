package com.SIREB.servicios;

/**
 *
 * @author Kike
 */
import com.SIREB.modelos.BarrioZona;
import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.Evento;
import com.SIREB.modelos.Grado;
import com.SIREB.modelos.Intervencion;
import com.SIREB.modelos.enums.Accion;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioEventos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * esta clase Proporciona los servicios necesarios a los EndPoints relacionados
 * a Eventos
 */
@Slf4j
@Service
public class ServicioEventos {

  @Autowired
  private RepositorioEventos repositorioEventos;
  @Autowired
  private ServicioSesion sesionServicio;
  @Autowired
  private RepositorioBombero repositorioBombero;

  public void agregarEvento(Evento evento) throws IOException {
    Date fecha = new Date();
    evento.setFecha(fecha);
    try {
      repositorioEventos.save(evento);
    } catch (Exception e) {
      String tipo = evento.getTipo();
      String mensaje = evento.getMensaje();
      Integer idBombero = evento.getIdBombero();
      escribirArchivo("eventos", "eventos/eventos.txt", tipo + "," + mensaje + "," + fecha + "," + idBombero + "\n");
      escribirObjeto("eventos", "eventos.txt", evento);
    }
  }

  public List<Evento> buscarPorTipo(String tipo) {
    return repositorioEventos.buscarPorTipo(tipo);
  }

  public Evento buscarPorId(Integer idEventos) {
    return repositorioEventos.buscarPorId(idEventos);
  }

  public void escribirArchivo(String carpeta, String archivo, String datos) throws IOException {
    File arch = new File(carpeta);
    if (!arch.exists()) {
      if (arch.mkdir()) {
        log.info("Se creo el directorio para eventos.");
      } else {
        log.error("Atencion, error catastrofico! Fallo la creacion del directorio de eventos.");
      }
    }

    BufferedWriter escribirArch = new BufferedWriter(new FileWriter(archivo, true));
    escribirArch.write(datos);
    escribirArch.flush();
    escribirArch.close();
  }

  public void escribirObjeto(String carpeta, String archivo, Evento evento) throws FileNotFoundException, IOException {
    ObjectOutputStream escribirArch = new ObjectOutputStream(new FileOutputStream(carpeta + "/" + archivo));
    escribirArch.writeObject(evento);
  }

  /**
   * este metodo crea un nuevo evento, pero no lo agrega al repositorio de ventos
   * @param llave token de usuario
   * @param accion accion llevada a cabo por el usuario
   * @param objeto objeto sobre el que se lleva a cabo la accion
   * @return un evento 
   */
  public Evento nuevoEvento(String llave, Accion accion, Object objeto) {
    Evento evento = null;
    //Control si el objeto es de tipo Bombero
    if (objeto.getClass().equals(Bombero.class)) {
      Bombero bombero = (Bombero) objeto;
      Integer idBomberoAdmin = sesionServicio.leerSesion(llave).getIdBombero();
      Bombero bomberoAdmin = repositorioBombero.findById(idBomberoAdmin).get();
      String nombre = bomberoAdmin.getNombre1() + " " + bomberoAdmin.getNombre2()==null?"":bomberoAdmin.getNombre2();
      String apellido = bomberoAdmin.getApellido();
      String afectado = bombero.getNombre1() + " con DNI: " + bombero.getDNI();
      evento = new Evento(accion.getActual(), "El bombero " + nombre + " " + apellido + "" + accion.getPasado() + " a " + afectado + ".", idBomberoAdmin);
    }
    if (objeto.getClass().equals(Grado.class)) {
      Grado grado = (Grado) objeto;
      Integer idBomberoAdmin = sesionServicio.leerSesion(llave).getIdBombero();
      Bombero bomberoAdmin = repositorioBombero.findById(idBomberoAdmin).get();
      String nombre = bomberoAdmin.getNombre1() + " " + bomberoAdmin.getNombre2();
      String apellido = bomberoAdmin.getApellido();
      String afectado = grado.getGrado() + " con id: " + grado.getIdGrado();
      evento = new Evento(accion.getActual(), "El bombero " + nombre + " " + apellido + "" + accion.getPasado() + " a " + afectado + ".", idBomberoAdmin);
    }
    if (objeto.getClass().equals(BarrioZona.class)) {
      BarrioZona barrioZona = (BarrioZona) objeto;
      Integer idBomberoAdmin = sesionServicio.leerSesion(llave).getIdBombero();
      Bombero bomberoAdmin = repositorioBombero.findById(idBomberoAdmin).get();
      String nombre = bomberoAdmin.getNombre1() + " " + bomberoAdmin.getNombre2();
      String apellido = bomberoAdmin.getApellido();
      String afectado = barrioZona.getBarrioZona() + " con id: " + barrioZona.getIdBarrioZona();
      evento = new Evento(accion.getActual(), "El bombero " + nombre + " " + apellido + "" + accion.getPasado() + " a " + afectado + ".", idBomberoAdmin);
    }
    if (objeto.getClass().equals(Intervencion.class)) {
      Intervencion intervencion = (Intervencion) objeto;
      Integer idBomberoAdmin = sesionServicio.leerSesion(llave).getIdBombero();
      Bombero bomberoAdmin = repositorioBombero.findById(idBomberoAdmin).get();
      String nombre = bomberoAdmin.getNombre1() + " " + bomberoAdmin.getNombre2();
      String apellido = bomberoAdmin.getApellido();
      String afectado ="La intervencion con Ticket: " + intervencion.getTicket();
      evento = new Evento(accion.getActual(), "El bombero " + nombre + " " + apellido + "" + accion.getPasado() + " a " + afectado + ".", idBomberoAdmin);
    }
    return evento;
  }

  /**
   * este metodo genera un evento del tipo "Listado"
   * @param llave el token de usuario
   * @param consulta el nombre de objeto consultado
   * @return  un evento del tipo listado
   */
  public Evento nvoEventoListado(String llave,String consulta) {
    Evento evento = null;
      Integer idBomberoAdmin = sesionServicio.leerSesion(llave).getIdBombero();
      Bombero bomberoAdmin = repositorioBombero.findById(idBomberoAdmin).get();
      String nombre = bomberoAdmin.getNombre1() + " " + bomberoAdmin.getNombre2();
      String apellido = bomberoAdmin.getApellido();
      evento = new Evento("Listado", "El bombero " + nombre + " " + apellido + " consulto el listado de " + consulta, idBomberoAdmin);
    return evento;
  }

}
