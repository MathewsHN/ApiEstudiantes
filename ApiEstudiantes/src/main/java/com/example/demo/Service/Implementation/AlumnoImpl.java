package com.example.demo.Service.Implementation;


import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Entitys.Alumno;
import com.example.demo.Entitys.Usuario;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Exceptions.ValidationException;
import com.example.demo.Mappers.AlumnoMapper;
import com.example.demo.Repository.AlumnoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AlumnoService;
import com.example.demo.Validation.AlumnoValidator;
import com.example.demo.Validation.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoImpl implements AlumnoService {


    private final AlumnoRepository alumnoRepository;
    private  final UsuarioValidator usuarioValidator;

    @Autowired

    public AlumnoImpl(AlumnoRepository alumnoRepository ,UsuarioValidator usuarioValidator) {
        this.alumnoRepository = alumnoRepository;
        this.usuarioValidator = usuarioValidator;

    }


    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return  alumnos.stream()
                .map(AlumnoMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public AlumnoDTO save(AlumnoDTO alumnoDTO) {

        AlumnoValidator.validarAlumno(alumnoDTO);
        usuarioValidator.ValidarUser(alumnoDTO.getUser());
       Alumno alumno = AlumnoMapper.toEntity(alumnoDTO);

       alumnoRepository.save(alumno);

        return AlumnoMapper.toDTO(alumno);

    }

    @Override
    public AlumnoDTO findById(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Alumno no encontrado con ID : " + id));

        return  AlumnoMapper.toDTO(alumno);
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);

    }

    @Override
    public List<Alumno> findByName(String name) {
        return (List<Alumno>) alumnoRepository.findByName(name);
    }

    @Override
    public AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoUpdate) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID : " + id));

        AlumnoValidator.validarAlumno(alumnoUpdate);
        usuarioValidator.ValidarUser(alumnoUpdate.getUser());

        alumnoExistente.setName(alumnoUpdate.getName());
        alumnoExistente.setLastname(alumnoUpdate.getLastname());
        alumnoExistente.setAge(alumnoUpdate.getAge());


        alumnoRepository.save(alumnoExistente);

        return AlumnoMapper.toDTO(alumnoExistente);


    }

}
