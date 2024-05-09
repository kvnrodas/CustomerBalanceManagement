package com.gt.web;

import lombok.extern.slf4j.Slf4j;
import com.gt.domain.Persona;
import com.gt.servicio.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller class for handling web requests related to the home page and user
 * interactions. Manages CRUD operations for Persona entities and displays home
 * page information.
 *
 * This class is marked as a Spring MVC controller component.
 *
 * Logs events using SLF4J.
 *
 * Performs input validation using javax validation annotations.
 *
 * Uses PersonaService for managing Persona entities.
 *
 * @author [Your Name]
 */
@Controller
@ComponentScan
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    /**
     * Handles GET requests for the home page ("/"). Retrieves a list of
     * personas and calculates total saldo and total clientes.
     *
     * @param model The model to add attributes for rendering the view.
     * @param user The authenticated user, injected using
     * @AuthenticationPrincipal.
     * @return The name of the view to render.
     */
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        log.info("Executing Spring MVC controller");
        log.info("User logged in: " + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for (var p : personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());

        return "index";
    }

    /**
     * Handles GET requests for adding a new persona ("/agregar").
     *
     * @param persona A new Persona object to be populated and bound to the
     * form.
     * @return The name of the view to render.
     */
    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    /**
     * Handles POST requests for saving a new or updated persona ("/guardar").
     * Performs input validation and saves the persona using PersonaService.
     *
     * @param persona The Persona object to save.
     * @param errores Errors object containing validation errors, if any.
     * @return The URL to redirect to after saving.
     */
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    /**
     * Handles GET requests for editing an existing persona
     * ("/editar/{idPersona}"). Retrieves the persona by ID and populates the
     * model for the view.
     *
     * @param persona A Persona object to populate with the ID.
     * @param model The model to add attributes for rendering the view.
     * @return The name of the view to render.
     */
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    /**
     * Handles GET requests for deleting a persona ("/eliminar").
     *
     * @param persona The Persona object to delete.
     * @return The URL to redirect to after deleting.
     */
    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }

    /**
     * Handles GET requests for the login page ("/login").
     *
     * @return The name of the view to render.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
