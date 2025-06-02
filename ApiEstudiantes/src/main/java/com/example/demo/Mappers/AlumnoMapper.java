package com.example.demo.Mappers;

import com.example.demo.Controller.DTO.AlumnoDTO;
import com.example.demo.Controller.DTO.UsuarioDTO;
import com.example.demo.Entitys.Alumno;
import com.example.demo.Entitys.Usuario;

public class AlumnoMapper {

    public static Alumno toEntity(AlumnoDTO dto){

        Usuario user = new Usuario();
        user.setUsername(dto.getUser().getUsername());
        user.setEmail(dto.getUser().getEmail());
        user.setPassword(dto.getUser().getPassword());

        Alumno alumno = new Alumno();
        alumno.setName(dto.getName());
        alumno.setLastname(dto.getLastname());
        alumno.setAge(dto.getAge());
        alumno.setUser(user);

        return alumno;

    }

    public static AlumnoDTO toDTO(Alumno entity){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsername(entity.getUser().getUsername());
        usuarioDTO.setEmail(entity.getUser().getEmail());
        usuarioDTO.setPassword(entity.getUser().getPassword());

        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setName(entity.getName());
        alumnoDTO.setLastname(entity.getLastname());
        alumnoDTO.setAge(entity.getAge());
        alumnoDTO.setUser(usuarioDTO);

        return alumnoDTO;
    }

}
