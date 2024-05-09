package com.gt.dao;

import com.gt.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for accessing and managing Persona entities in the database.
 * Extends JpaRepository to inherit basic CRUD operations.
 *
 * @author Kevin
 */
public interface PersonaDao extends JpaRepository<Persona, Long> {

}
