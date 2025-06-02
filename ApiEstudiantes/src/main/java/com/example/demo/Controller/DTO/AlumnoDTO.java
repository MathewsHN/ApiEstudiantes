package com.example.demo.Controller.DTO;

import com.example.demo.Entitys.Usuario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AlumnoDTO {



    private long id;


    private String name;

    private String lastname;

    private int age;


    private UsuarioDTO user;
}
