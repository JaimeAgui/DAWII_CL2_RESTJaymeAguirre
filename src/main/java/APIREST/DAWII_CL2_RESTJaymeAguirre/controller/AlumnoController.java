package APIREST.DAWII_CL2_RESTJaymeAguirre.controller;


import APIREST.DAWII_CL2_RESTJaymeAguirre.model.db.Alumno;
import APIREST.DAWII_CL2_RESTJaymeAguirre.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumno(){
        List<Alumno> alumnosList = new ArrayList<>();
        alumnoService.listarAlumno().forEach(alumnosList::add);
        if(alumnosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerEstadoxId(@PathVariable("id") String id){
        return new ResponseEntity<>(
                alumnoService.buscarEstadoxId(id).get(),
                HttpStatus.OK);
    }

   @PostMapping("")
    public ResponseEntity<Alumno> registrar(@RequestBody Alumno alumno){
        Alumno newAlumno = new Alumno();
        newAlumno.setApealumno(alumno.getApealumno());
        return new ResponseEntity<>(alumnoService.registrar(newAlumno),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(
            @PathVariable("id") String id,
            @RequestBody Alumno alumno){
        Alumno updateAlumno= alumnoService.buscarEstadoxId(id).get();
        updateAlumno.setApealumno(alumno.getApealumno());
        return new ResponseEntity<>(alumnoService.registrar(updateAlumno),
                HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable("id") String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alumnoService.eliminarxId(id));
    }
//
}
