package com.example.demo.Service;

import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Entitys.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO save(AlumnoDTO alumnoDTO);
   AlumnoDTO findById(Long id);
    void delete(Long id);
    List<Alumno> findByName(String name);
    AlumnoDTO updateAlumno(Long id , AlumnoDTO alumno);
}
