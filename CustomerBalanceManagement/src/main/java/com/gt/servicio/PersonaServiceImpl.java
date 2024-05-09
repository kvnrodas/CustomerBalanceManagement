package com.gt.servicio;

import java.util.List;
import com.gt.dao.PersonaDao;
import com.gt.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the PersonaService interface. Provides functionality for
 * managing Persona entities.
 *
 * Uses PersonaDao for database operations.
 *
 * This class is marked as a service component to be automatically detected by
 * Spring.
 *
 * Handles transactions for service methods.
 *
 * @author Kevin
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        // Retrieves a list of all Persona entities from the database
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        // Saves a new Persona entity or updates an existing one in the database
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        // Deletes a Persona entity from the database
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        // Finds a Persona entity by its ID
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
