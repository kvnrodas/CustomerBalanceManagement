package com.gt.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a person entity in the system. This class defines the attributes
 * and constraints for a person.
 *
 * @author KeV
 */
@Getter
@Setter
@Entity
@Table(name = "persona") // Indicates the name of the table in the database
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long idPersona; // Unique identifier for the person

    @NotEmpty // Specifies that the name cannot be empty
    private String nombre; // First name of the person

    @NotEmpty // Specifies that the last name cannot be empty
    private String apellido; // Last name of the person

    @NotEmpty // Specifies that the email cannot be empty
    @Email // Specifies that the email should be in a valid email format
    private String email; // Email address of the person

    private String telefono; // Phone number of the person

    @NotNull // Specifies that the saldo cannot be null
    private Double saldo; // Account balance of the person

}
