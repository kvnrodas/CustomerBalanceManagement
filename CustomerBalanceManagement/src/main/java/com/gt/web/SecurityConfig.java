package com.gt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security settings.
 *
 * Configures authentication, authorization, and other security-related
 * settings.
 *
 * This class is annotated with @EnableWebSecurity to enable Spring Security's
 * web security features.
 *
 * It defines a BCryptPasswordEncoder bean for encoding passwords.
 *
 * Configures authentication using a custom UserDetailsService and password
 * encoder.
 *
 * Configures authorization rules for different URL patterns and roles.
 *
 * Handles login, logout, and access denied behavior.
 *
 * Allows customization of web security settings, such as ignoring certain
 * requests.
 *
 * @author KeV
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Bean definition for BCryptPasswordEncoder.
     *
     * @return A BCryptPasswordEncoder instance.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures authentication manager with custom UserDetailsService and
     * password encoder.
     *
     * @param build The AuthenticationManagerBuilder to configure.
     * @throws Exception If an error occurs during configuration.
     */
    public void configurer(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(
                passwordEncoder());
    }

    /**
     * Configures HTTP security settings.
     *
     * @param http The HttpSecurity object to configure.
     * @return A SecurityFilterChain instance.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
            Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/editar/**", "/eliminar/**", "/agregar/**").
                hasRole("ADMIN")
                .requestMatchers("/", "/login/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated())
                .exceptionHandling((exceptionHandling)
                        -> exceptionHandling
                        .accessDeniedPage("/errores/403"))
                .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                ).logout((logout) -> logout
                .logoutSuccessUrl("/login")
                .permitAll());
        return http.build();
    }

    /**
     * Provides custom web security customization.
     *
     * @return A WebSecurityCustomizer instance.
     */
    @Bean
    WebSecurityCustomizer customizeWebSecurity() {
        return (web) -> web.ignoring().requestMatchers("/css/**");
    }
}
