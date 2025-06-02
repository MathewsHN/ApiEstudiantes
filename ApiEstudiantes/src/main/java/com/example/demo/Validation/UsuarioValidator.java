package com.example.demo.Validation;

import com.example.demo.Controller.DTO.UsuarioDTO;
import com.example.demo.Exceptions.ValidationException;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {


    private UserRepository userRepository;


    public UsuarioValidator (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public  void ValidarUser (UsuarioDTO userDto){

        if(userRepository.existByCorreo(userDto.getEmail())){
            throw  new ValidationException("El correo ya se encuentra registrado : " + userDto.getEmail());
        }

        if(userRepository.existByUsername(userDto.getUsername())){
            throw  new ValidationException("El nombre de usuario no se encuentra disponible: " + userDto.getUsername());
        }

    }
}
