package com.example.demo.Service;


import com.example.demo.Entitys.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<Usuario> findByAll();
    Optional<Usuario> findByNameUser(String nameUser);
    Optional <Usuario> findByEmail (String email);
    Usuario UpdateUser(Long id , Usuario usuarioUpdate);


}
