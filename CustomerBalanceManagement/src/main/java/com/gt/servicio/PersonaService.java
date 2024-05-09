package com.gt.servicio;

import java.util.List;
import com.gt.domain.Persona;

/**
 * Interface for managing operations related to Persona entities. Defines
 * methods for listing, saving, deleting, and finding Persona entities.
 *
 * Implementations of this interface should provide functionality for
 * interacting with Persona entities.
 *
 * @author Kevin
 */
public interface PersonaService {

    /**
     * Retrieves a list of all Persona entities.
     *
     * @return A list of Persona entities.
     */
    public List<Persona> listarPersonas();

    /**
     * Saves a new Persona entity or updates an existing one.
     *
     * @param persona The Persona entity to save or update.
     */
    public void guardar(Persona persona);

    /**
     * Deletes a Persona entity from the database.
     *
     * @param persona The Persona entity to delete.
     */
    public void eliminar(Persona persona);

    /**
     * Finds a Persona entity by its properties.
     *
     * @param persona The Persona entity with properties to search for.
     * @return The found Persona entity, or null if not found.
     */
    public Persona encontrarPersona(Persona persona);
}
