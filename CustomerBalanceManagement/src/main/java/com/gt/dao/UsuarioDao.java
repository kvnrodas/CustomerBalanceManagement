package com.gt.dao;

import com.gt.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for accessing and managing Usuario entities in the database.
 * Extends JpaRepository to inherit basic CRUD operations.
 *
 * Provides a method to find a Usuario entity by its username.
 *
 * @author Kevin
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    /**
     * Retrieves a Usuario entity by its username.
     *
     * @param username The username of the Usuario entity to retrieve.
     * @return The Usuario entity with the specified username, or null if not
     * found.
     */
    Usuario findByUsername(String username);
}
