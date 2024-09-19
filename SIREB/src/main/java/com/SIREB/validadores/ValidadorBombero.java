package com.SIREB.validadores;

import com.SIREB.modelos.Bombero;
import com.SIREB.modelos.enums.FactorSanguineo;
import com.SIREB.modelos.enums.Genero;
import com.SIREB.repositorios.RepositorioBombero;
import com.SIREB.repositorios.RepositorioCuartel;
import com.SIREB.repositorios.RepositorioGrado;
import com.SIREB.repositorios.RepositorioMotivoBaja;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Wanda
 */
@Slf4j
@Component
public class ValidadorBombero {

   /* private ServicioMotivoBaja motivoBajaServicio;
    private ServicioCuartel servicioCuartel;
    private ServicioGrado servicioGrado;
    private ServicioSesion servicioSesion;
    
    @Autowired    
    public ValidadorBombero(ServicioMotivoBaja motivoBajaServicio,
            ServicioCuartel servicioCuartel, ServicioGrado servicioGrado,
            ServicioSesion servicioSesion) {
        this.motivoBajaServicio = motivoBajaServicio;
        this.servicioCuartel = servicioCuartel;
        this.servicioGrado = servicioGrado;
        this.servicioSesion = servicioSesion;
       
    }
    
    public Map<String,Boolean> validarBombero (Bombero bombero, String llave){
        Map<String,Boolean> errores = new HashMap();
        errores.put("Nombre1", validarString(bombero.getNombre1(),"Nombre1"));
        errores.put("Nombre2", validarString(bombero.getNombre2(),"Nombre2"));
        errores.put("Apellido", validarString(bombero.getApellido(),"Apellido"));
        errores.put("Direccion", validarDireccion(bombero.getDireccion()));
        errores.put("DNI", validarDni(bombero.getDNI()));
        errores.put("TelefonoCasa", validarTelefonoCasa(bombero.getTelefonoCasa()));
        errores.put("TelefonoCelular", validarTelefonoCelular(bombero.getTelefonoCelular()));
        errores.put("FactorSanguineo", validarFactorSanguineo(bombero.getFactorSanguineo()));
        errores.put("Genero", validarGenero(bombero.getGenero()));
        errores.put("Edad", validarEdad(bombero.getEdad(),"Edad", 18, 100));
        errores.put("IdMotivoBaja",validarBaja(bombero.getIdMotivoBaja()));
        errores.put("IdCuartel",validarCuartel(bombero.getIdCuartel(),llave));
        errores.put("IdGrado",validarGrado(bombero.getIdGrado(), llave));
        errores.put("FechaNacimiento",validarFecha(bombero.getFechaNacimiento(),"FechaNacimiento"));
        errores.put("FechaAlta",validarFecha(bombero.getFechaAlta(),"FechaAlta"));
        errores.put("FechaBaja",validarFecha(bombero.getFechaBaja(),"FechaBaja"));
        
        return errores;
    }
    
    /*private Boolean validarString(String nombre1, String llave){
        boolean estado = true;
        if(nombre1 == null || nombre1.isEmpty()|| !nombre1.matches("^(?!\\s*$)[a-zA-Z]{3,10}$")){
            log.info("El string {} es incorrecto:{}.", llave, nombre1);
           estado = false;
        }
        return estado;
       
    }
    
    private Boolean validarDireccion (String direccion){
        boolean estado = true;
        if(direccion == null || direccion.isEmpty()|| !direccion.matches("^(?!\\s*$)[a-zA-Z 0-9]+$")){
            log.info("La direccion es incorrecta:{}.", direccion);
            estado = false;
        }
        return estado;
        
    }
    
    private Boolean validarDni (String dni){
        boolean estado = true;
        if(dni == null || dni.isEmpty()|| !dni.matches("^(?!\\s*$)[0-9]{7,8}+$")){
            log.info("El dni es incorrecto:{}.", dni);
            estado = false;
        }
        return estado;
        
    }
    
    private Boolean validarTelefonoCelular (String telefonoCelular){
        boolean estado = true;
        if(telefonoCelular == null || telefonoCelular.isEmpty()|| !telefonoCelular.matches("^(?!\\s*$)[0-9]{6,11}+$")){
            log.info("El telefono {} es incorrecto:{}.",telefonoCelular);
            estado=false;
        }
        return estado;
    }
    
    private Boolean validarTelefonoCasa (String telefonoCasa){
        boolean estado = true;
         
        if(!telefonoCasa.matches("^(?!\\s*$)[0-9]{6,11}+$")){
            log.info("El telefono {} es incorrecto:{}.", telefonoCasa);
            estado=false;
        }
        return estado;
    }
    
    
    private Boolean validarFactorSanguineo(String factorSanguineo ){
        boolean estado = true;
        try{
            FactorSanguineo.valueOf(factorSanguineo);
        }catch(IllegalArgumentException e){
            log.info("El factor sanguineo es incorrecto:{}.", factorSanguineo);
            estado = false;
        }
        return estado;
       
    }
    
    private Boolean validarGenero (String genero){
        boolean estado = true;
        try{
            Genero.valueOf(genero);
        }catch(IllegalArgumentException e){
            log.info("El genero es incorrecto: {}.", genero);
            estado = false;
        }
        return estado;

    }*/
  
  private RepositorioCuartel repositorioCuartel;
  private RepositorioGrado repositorioGrado;
  private RepositorioMotivoBaja repositorioBaja;
  private RepositorioBombero repositorioBombero;

  private HashMap<Boolean, HashMap> listaErrores = new HashMap<>();
  private HashMap<String, Boolean> errores = new HashMap<>();

  @Autowired
  public ValidadorBombero(RepositorioCuartel repositorioCuartel, RepositorioGrado repositorioGrado, 
    RepositorioMotivoBaja repositorioBaja,RepositorioBombero repositorioBombero) {
    this.repositorioCuartel = repositorioCuartel;
    this.repositorioGrado = repositorioGrado;
    this.repositorioBaja = repositorioBaja;
    this.repositorioBombero = repositorioBombero;
  }

  public HashMap<Boolean, HashMap> validarBombero(Bombero bombero) {
    validarNombre1(bombero.getNombre1());
    validarNombre2(bombero.getNombre2());
    validarNombre1(bombero.getApellido());
    validarDireccion(bombero.getDireccion());
    validarTelefonoCelular(bombero.getTelefonoCelular());
    validartelefonoCasa(bombero.getTelefonoCasa());
    validarFactorSanguineo(bombero.getFactorSanguineo());
    validarGenero(bombero.getGenero());
    validarEdad(bombero.getEdad(), 18, 100);
    validarBaja(bombero.getIdMotivoBaja());
    validarCuartel(bombero.getIdCuartel());
    validarGrado(bombero.getIdGrado());
    validarFechaAlta(bombero.getFechaAlta());
    validarFechaBaja(bombero.getFechaBaja(), bombero.getFechaAlta());
    validarExisteBombero(bombero.getDNI());

    if (errores.containsValue(false)) {
      listaErrores.put(false, errores);
    } else {
      listaErrores.put(true, errores);
    }
    return listaErrores;
  }
  /**
   * este metodo se utiliza al actualizar un bombero
   * @param bombero el objeto bombero con nuevos datos
   * @param id el id del bombero a actualizar
   * @return  mapa de errores
   */
  public HashMap<Boolean,HashMap> validarBombero(Bombero bombero,Integer id){
    validarNombre1(bombero.getNombre1());
    validarNombre2(bombero.getNombre2());
    validarNombre1(bombero.getApellido());
    validarDireccion(bombero.getDireccion());
    validarDni(bombero.getDNI());
    validarDni2(bombero.getDNI(), id);
    validarTelefonoCelular(bombero.getTelefonoCelular());
    validartelefonoCasa(bombero.getTelefonoCasa());
    validarFactorSanguineo(bombero.getFactorSanguineo());
    validarGenero(bombero.getGenero());
    validarEdad(bombero.getEdad(), 18, 100);
    validarBaja(bombero.getIdMotivoBaja());
    validarCuartel(bombero.getIdCuartel());
    validarGrado(bombero.getIdGrado());
    validarFechaAlta(bombero.getFechaAlta());
    validarFechaBaja(bombero.getFechaBaja(), bombero.getFechaAlta());
    validarId(id);

    if(errores.containsValue(false)){
      listaErrores.put(false, errores);
      return listaErrores;
    }else{
      listaErrores.put(true, errores);
      return listaErrores;
    }
  }
  
  public HashMap<Boolean,HashMap> validarBombero(String dni){
    validarExisteDni(dni);
    if(errores.containsValue(false)){
      listaErrores.put(false, errores);
      return listaErrores;
    }else{
      listaErrores.put(true, errores);
      return listaErrores;
    }
    
  }
  
  private void validarExisteDni(String dni){
    if(!repositorioBombero.existsByDNI(dni)){
      errores.put("El dni ingresado no existe", false);
    }
  }

  private void validarNombre1(String nombre1) {
    if (nombre1 == null || nombre1.isBlank() || !nombre1.matches("^(?!\\s*$)[a-zA-Z ñÑ]{3,20}$")) {
      errores.put("Error en el  primer nombre", false);
    }
  }private void validarNombre2(String nombre2) {
    if(nombre2!=null){
      if (nombre2.isBlank() || !nombre2.matches("^(?!\\s*$)[a-zA-Z ñÑ]{3,20}$")) {
      errores.put("Error en el segundo nombre", false);
    }
    }
  }
    
  private void validarDireccion(String direccion) {
    if (direccion == null || direccion.isBlank() || !direccion.matches("^(?!\\s*$)[a-zA-Z ñÑ 0-9]+$")) {
      errores.put("La direccion es incorrecta", false);
    }
  }

  private void validarDni(String dni) {
    if (dni == null || dni.isBlank() || !dni.matches("^(?!\\s*$)[0-9]{7,8}+$")) {
      errores.put("El dni es incorrecto", false);
    }
  }
  
  private void validarDni2(String dni,int id){
    if(!repositorioBombero.findById(id).isEmpty()){
      String dniRepo = repositorioBombero.findById(id).get().getDNI();
      if(!Objects.equals(dniRepo, dni) && repositorioBombero.existsByDNI(dni)){
       errores.put("El dni ingresado ya existe", false);
      } 
    } 
  }

  private void validarTelefonoCelular(String telefonoCelular) {

    if (telefonoCelular == null || telefonoCelular.isBlank() || !telefonoCelular.matches("^(?!\\s*$)[0-9]{6,15}+$")) {
      errores.put("El telefono celular es incorrecto.", false);
    }
  }

  private void validartelefonoCasa(String telefonoCasa) {
    if (Objects.nonNull(telefonoCasa) && (telefonoCasa.isBlank() || !telefonoCasa.matches("^(?!\\s*$)[0-9]{6,15}+$"))){
      errores.put("El telefono fijo es incorrecto", false);
    }

  }

  private void validarFactorSanguineo(String factorSanguineo) {
   
      for(FactorSanguineo factor:FactorSanguineo.values()){
        if(factor.getValue().equals(factorSanguineo)){
          return;
        }
      }
      errores.put("El factor sanguineo es incorrecto", false);
    }
  

  private void validarGenero(String genero) {
    for(Genero esteGenero:Genero.values()){
        if(esteGenero.getValue().equals(genero)){
          return;
        }
      }
      errores.put("El Genero es incorrecto", false);
    }

  private void validarEdad(Integer valor, Integer minimo, Integer maximo) {
    if (Objects.isNull(valor) || valor <= minimo || valor > maximo) {
      errores.put("La edad es incorrecta:", false);
    }
  }

  private void validarBaja(Integer idMotivoBaja) {
    if (Objects.nonNull(idMotivoBaja) && !repositorioBaja.existsById(idMotivoBaja)) {
      errores.put("El motivo de Baja no existe", false);
    }
  }

  private void validarCuartel(Integer idCuartel) {
    if (Objects.isNull(idCuartel) || !repositorioCuartel.existsById(idCuartel)) {
      errores.put("El cuartel no existe.", false);
    }
  }

  private void validarGrado(Integer idGrado) {
    if (Objects.isNull(idGrado) || !repositorioGrado.existsById(idGrado)) {
      errores.put("El grado no existe.", false);
    }
  }

  private void validarFechaAlta(Date fecha) {

    if (fecha.after(new Date())) {
      errores.put("La fecha es incorrecta.", false);
    }

  }

  private void validarFechaBaja(Date fechaBaja, Date fechaAlta) {
    if (Objects.nonNull(fechaBaja) && (fechaBaja.before(fechaAlta) || fechaBaja.equals(fechaAlta))) {
      errores.put("La fecha es incorrecta.", false);
    }
  }
  
  private void validarExisteBombero(String dni){
    if(repositorioBombero.existsByDNI(dni)){
      errores.put("Existe un bombero con el dni " + dni,false);
    }
  }
  
  private void validarId(Integer id){
    if(id==null){
      errores.put("id Nulo", false);
    }
    if(id<0){
      errores.put("El id es menor a 0", false);
    }
    if(!repositorioBombero.existsById(id)){
      errores.put("El id " + id + " no existe", false);
    }
  }
}

