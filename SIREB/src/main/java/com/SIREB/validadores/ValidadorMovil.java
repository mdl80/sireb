package com.SIREB.validadores;

import com.SIREB.modelos.Movil;
import com.SIREB.repositorios.RepositorioMovil;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Esta clase es la encarga de realizar todas las validaciones correspondientes
 * a los datos de los moviles
 *
 * @author Marcelo Llanes
 */
@Slf4j
public class ValidadorMovil {

  private RepositorioMovil repositorio;
  private HashMap<String, Boolean> listaErrores = new HashMap<>();
  private HashMap<Boolean, HashMap> errores = new HashMap<>();
  
  @Autowired
  public ValidadorMovil(RepositorioMovil repositorio){
    this.repositorio = repositorio;
  }

  public HashMap<Boolean,HashMap> validarMovil(Movil movil) {
    validarNulo(movil);
    validarClase(movil);
    if(listaErrores.containsValue(false)){
      errores.put(false, listaErrores);
      return errores;
    }
    validarMarca(movil);
    validarModelo(movil);
    validarNumMovil(movil);
    validarPlaza(movil);
    if(listaErrores.containsValue(false)){
      errores.put(false, listaErrores);
      return errores;
    }else{
      errores.put(true, listaErrores);
      return errores;
    }
  }
  public HashMap<Boolean,HashMap> validarMovil(int numeroMovil){
    validarNumeroMovil(numeroMovil);
    if(listaErrores.containsValue(false)){
      errores.put(false, listaErrores);
    }else{
      errores.put(true, listaErrores);
    }
    return errores;
  }
  
  public HashMap<Boolean,HashMap> validarIdMovil(int idMovil){
    validarId(idMovil);
    if(listaErrores.containsValue(false)){
      errores.put(false, listaErrores);
    }else{
      errores.put(true, listaErrores);
    }
    return errores;
  }
  
  private void validarId(int id){
    if(id<0){
      listaErrores.put("el id no puede ser menor a 0", false);
    }
    if(!repositorio.existsById(id)){
      listaErrores.put("No existe el Id en la db", false);
    }
  }
  
  private void validarNumeroMovil(int numeroMovil){
    if(numeroMovil<0){
      listaErrores.put("El numero de movil es menor a 0", false);
    }
    if(!repositorio.existsByNumeroMovil(numeroMovil)){
      listaErrores.put("El numero de movil no existe o no se encuentra asignado", false);
    }
  }

  private void validarMarca(Movil movil) {
    if(movil.getMarca()!=null){
      if (movil.getMarca().isEmpty() || movil.getMarca().isBlank()) {
      listaErrores.put("Marca en blanco", false);
    }
    if (!movil.getMarca().matches("^[a-zA-Z ñÑ 0-9]+$")) {
      listaErrores.put("Caracteres invalidos utilizados",false);
    }
    }else{
      listaErrores.put("Nombre de marca nulo",false);
    }
  }
  
  private void validarModelo(Movil movil) {
   if(movil.getModelo()!=null){
      if (movil.getModelo().isEmpty() || movil.getModelo().isBlank()) {
      listaErrores.put("Grado en blanco", false);
    }
    if (!movil.getModelo().matches("^[a-zA-Z 0-9 ñÑ]+$")) {
      listaErrores.put("Caracteres invalidos utilizados",false);
    }
   }
  }
  
  private void validarNumMovil(Movil movil){
    if(movil.getNumeroMovil()!=null){
      if(movil.getNumeroMovil()<=0){
        listaErrores.put("Numero de movil incorrecto", false);
      }
      if(repositorio.existsByNumeroMovil(movil.getNumeroMovil())){
        listaErrores.put("El numero de movil ya se encuentra asignado", false);
      }
    }
  }
  
  private void validarPlaza(Movil movil){
    if(movil.getPlaza()!= null){
      if(movil.getPlaza()<0){
        listaErrores.put("El numero de plazas no puede ser menor a 0", false);
      }
    }
  }
  
  private void validarNulo(Movil movil){
    if(movil == null){
      listaErrores.put("el movil es nulo",false);
    }
  }
  
  private void validarClase(Movil movil){
    if(!movil.getClass().equals(Movil.class)){
      listaErrores.put("El movil no es de la clase esperada",false);
    }
  }
}
