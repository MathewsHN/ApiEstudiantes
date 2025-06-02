package com.example.demo.Controller;

import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Entitys.Alumno;
import com.example.demo.Service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    //Endpoint Para Registrar Alumno Nuevo
    @PostMapping("/save")
    public ResponseEntity<AlumnoDTO> save(@RequestBody @Valid AlumnoDTO alumnoDTO) {
        AlumnoDTO  creado = alumnoService.save(alumnoDTO);

        return  new ResponseEntity<>(creado, HttpStatus.CREATED);
    }


    // Endpoint Para Listar todo los Alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAll() {
        List<AlumnoDTO> alumnos = alumnoService.getAllAlumnos();
        return ResponseEntity.ok(alumnos);

    }


    //EndPoint Para Buscar Alumno por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> FindById(@PathVariable long id) {
        AlumnoDTO dto = alumnoService.findById(id);
        return ResponseEntity.ok(dto);


    }

    //Endpoint Para Actualiar Alumno

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> UpdateAlummno(@PathVariable long id, @RequestBody AlumnoDTO alumnoDetails) {
        AlumnoDTO actualizado = alumnoService.updateAlumno(id,alumnoDetails);
        return ResponseEntity.ok(actualizado);
    }

    //Endpoint para Eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable long id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
