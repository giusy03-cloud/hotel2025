package com.dipartimento.hoteldesperation.controller;

import com.dipartimento.hoteldesperation.model.Utente;
import com.dipartimento.hoteldesperation.repository.UtenteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") // Per integrare con Angular
public class AuthController {

    @Autowired
    private UtenteRepository utenteRepository;

    @PostMapping("/login")
    public String login(@RequestBody Utente utente, HttpSession session) {
        Utente authenticatedUser = utenteRepository.findByUsernameAndPassword(
                utente.getUsername(), utente.getPassword());
        if (authenticatedUser != null) {
            session.setAttribute("user", authenticatedUser);
            return "Login effettuato con successo!";
        }
        return "Username o password errati.";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logout effettuato con successo.";
    }

    @GetMapping("/isAuthenticated")
    public boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("user") != null;
    }
}
