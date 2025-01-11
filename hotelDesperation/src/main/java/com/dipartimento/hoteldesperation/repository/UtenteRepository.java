package com.dipartimento.hoteldesperation.repository;

import com.dipartimento.hoteldesperation.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
    // Puoi aggiungere metodi personalizzati, ad esempio:
    Utente findByUsernameAndPassword(String username, String password);
}