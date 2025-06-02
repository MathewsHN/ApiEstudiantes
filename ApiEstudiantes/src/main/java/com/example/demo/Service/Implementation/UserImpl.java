package com.example.demo.Service.Implementation;

import com.example.demo.Entitys.Usuario;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserImpl  implements UserService {

    private final UserRepository userRepository;
    @Autowired

    public UserImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<Usuario> findByAll() {
        return  (List<Usuario>) userRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByNameUser(String nameUser) {
        return  userRepository.findByNameUser(nameUser);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    @Override
    public Usuario UpdateUser(Long id, Usuario usuarioUpdate) {
        Usuario usuarioExistente = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Usuario no encontrado : " + usuarioUpdate ));

        return



    }
}
