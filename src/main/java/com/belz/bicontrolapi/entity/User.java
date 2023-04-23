package com.belz.bicontrolapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "usuario")
@Entity
public class User {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idUsuario;

    @Column(name = "id_usuario")
    private String email;

    @Column(name = "id_usuario")
    private String password;

    @Column(name = "id_usuario")
    private Boolean active;

    @Column(name = "id_usuario")
    private String randomToken;

    @Column(name = "id_usuario")
    private Date expirationRandomToken;

}
