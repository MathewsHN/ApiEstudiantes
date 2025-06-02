package com.example.demo.Repository;

import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Entitys.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoRepository  extends JpaRepository<Alumno,Long> {


    List <Alumno> findByName(String name);




}
