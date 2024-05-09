package com.gt.servicio;

import com.gt.dao.UsuarioDao;
import com.gt.domain.Rol;
import com.gt.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing user details and authentication. Implements the
 * UserDetailsService interface to provide custom user retrieval logic.
 *
 * This class retrieves user details from the UsuarioDao and constructs
 * UserDetails objects for Spring Security.
 *
 * Handles transactions for user retrieval operations.
 *
 * Logs authentication-related events using SLF4J.
 *
 * @author KeV
 */
@Service("userDetailsService")
@Slf4j
@Transactional(readOnly = true)
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {

        // Retrieve the user by username from the database
        Usuario usuario = usuarioDao.findByUsername(username);

        // Throw an exception if the user is not found
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        // Construct a list of granted authorities from the user's roles
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        // Create and return a UserDetails object representing the authenticated user
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
