package com.belz.bicontrolapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name = "role")
@Entity
public class Role {

    @Id
    @Column(name = "role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;


}
