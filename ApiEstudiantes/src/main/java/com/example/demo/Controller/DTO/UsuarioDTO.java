package com.example.demo.Controller.DTO;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UsuarioDTO {

    private long id;
    private String username;
    private String email;
    private String password;

}
