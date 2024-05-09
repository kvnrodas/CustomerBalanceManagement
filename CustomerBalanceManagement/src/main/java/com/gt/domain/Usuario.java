package com.gt.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "usuario") // Indicates the name of the table in the database
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long idUsuario; // Unique identifier for the user

    @NotEmpty // Specifies that the username cannot be empty
    private String username; // User's username

    @NotEmpty // Specifies that the password cannot be empty
    private String password; // User's password

    @OneToMany // Specifies a one-to-many relationship with the Rol entity
    @JoinColumn(name = "id_usuario") // Specifies the foreign key column in the Rol table
    private List<Rol> roles; // List of roles associated with the user

}
