package com.gt.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "rol") // Indicates the name of the table in the database
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long idRol; // Unique identifier for the role

    @NotEmpty // Specifies that the role name cannot be empty
    private String nombre; // Name of the role

}
