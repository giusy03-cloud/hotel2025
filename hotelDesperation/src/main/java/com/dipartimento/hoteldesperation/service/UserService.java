package com.dipartimento.hoteldesperation.service;

import com.dipartimento.hoteldesperation.dao.UserDAO;
import com.dipartimento.hoteldesperation.model.Utente;  // Usa la classe Utente
import com.dipartimento.hoteldesperation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Repository per interagire con il DB
    private UserDAO userDAO;

    // Metodo per registrare un nuovo utente
    public void registerUser(UserDAO userDAO) throws Exception { // Usa UserDTO
        // Verifica se l'email è già registrata
        if (userRepository.existsByEmail(userDAO.getEmail())) {
            throw new Exception("Email already in use");
        }

        // Crea un oggetto Utente e mappa i dati del DTO
        Utente newUtente = new Utente();  // Usa Utente invece di User
        newUtente.setUsername(userDAO.getUsername());
        newUtente.setEmail(userDAO.getEmail());

        // Cifra la password prima di salvarla
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDAO.getPassword());

        newUtente.setPassword(encodedPassword);

        // Salva l'utente nel database
        userRepository.save(newUtente);  // Salva l'oggetto Utente
    }
}
