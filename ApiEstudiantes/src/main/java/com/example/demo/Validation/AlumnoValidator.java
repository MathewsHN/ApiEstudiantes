package com.example.demo.Validation;

import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Exceptions.ValidationException;

public class AlumnoValidator {

    public static void validarAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            throw new ValidationException("El alumno no puede estar vacio");
        }

        if (alumnoDTO.getName() == null || alumnoDTO.getName().trim().isEmpty()) {
            throw new ValidationException("El nombre es obligatorio");
        }

        if (alumnoDTO.getLastname() == null || alumnoDTO.getLastname().trim().isEmpty()) {
            throw new ValidationException("El apellido es obligatorio");
        }

        if (alumnoDTO.getAge() <= 0) {
            throw new ValidationException("La edad debe ser mayor que cero");
        }

        if (alumnoDTO.getUser() == null) {
            throw new ValidationException("El usuario es obligatorio");
        }

        if (alumnoDTO.getUser().getEmail() == null || alumnoDTO.getUser().getEmail().trim().isEmpty()) {
            throw new ValidationException("El correo del usuario es obligatorio");
        }


        if (alumnoDTO.getUser().getPassword() == null || alumnoDTO.getUser().getPassword().trim().isEmpty()) {
            throw new ValidationException("La contraseña del usuario es obligatoria");
        }
    }
}
