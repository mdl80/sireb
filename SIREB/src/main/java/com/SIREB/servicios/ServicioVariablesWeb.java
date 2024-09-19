package com.SIREB.servicios;


import com.SIREB.modelos.Cuartel;
import com.SIREB.repositorios.RepositorioBarrioZona;
import com.SIREB.repositorios.RepositorioCuartel;
import com.SIREB.repositorios.RepositorioGrado;
import com.SIREB.repositorios.RepositorioTipoAviso;
import com.SIREB.repositorios.RepositorioTipoIntervencion;
import com.SIREB.repositorios.RepositorioTipoMovil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author kike
 */

@Service
public class ServicioVariablesWeb {
    @Autowired
    private RepositorioGrado repoGrados;
    
    @Autowired    
    private RepositorioCuartel repoCuartel;

    @Autowired    
    private RepositorioTipoMovil repoTipoMovil;

    @Autowired    
    private RepositorioBarrioZona repoBarrioZona;

    @Autowired    
    private RepositorioTipoIntervencion repoTipoIntervencion;
    
    @Autowired    
    private RepositorioTipoAviso repoTipoAviso;
    
    private final Map<String, List> mapaCfg = new HashMap<>();

    
    public ResponseEntity mostrarTodos(Integer idCuartel) {
    ResponseEntity respuesta = null;
    try {
        //Creo la lista trayendo los grados del repositorio (aca hay que refactorizar la db
        //para que los grados queden asociados al cuartel
        List grados = repoGrados.findAll();
        
        List tipoMovil = repoTipoMovil.findAll();
        
        List barrioZona = repoBarrioZona.findAll();
        
        List tipoIntervencion = repoTipoIntervencion.findAll();
        
        List tipoAviso = repoTipoAviso.findAll();
        
        //Aca creo un optional trayendo el cuartel con el id del Cuartel.
        //luego en la siguiente linea convierto el optional a lista o creo una lista vacia.
        Optional<Cuartel> opCuartel = repoCuartel.findById(idCuartel);
        List cuartel = opCuartel.map(List::of).orElse(Collections.emptyList());
        mapaCfg.put("Grados", grados);
        mapaCfg.put("Cuartel", cuartel);
        mapaCfg.put("TipoMovil", tipoMovil);
        mapaCfg.put("BarrioZonas", barrioZona);
        mapaCfg.put("tipoIntervencion", tipoIntervencion);
        mapaCfg.put("tipoAviso", tipoAviso);
        respuesta = new ResponseEntity(mapaCfg, HttpStatus.OK);
    } catch (Exception e) {

    }
    return respuesta;
  }
}
