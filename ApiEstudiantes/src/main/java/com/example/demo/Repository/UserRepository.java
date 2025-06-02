package com.example.demo.Repository;

import com.example.demo.Entitys.Alumno;
import com.example.demo.Entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNameUser(String nameUser);

    Optional<Usuario> findByEmail(String email);

    Boolean existByCorreo(String correo);
    Boolean existByUsername(String username);


}
