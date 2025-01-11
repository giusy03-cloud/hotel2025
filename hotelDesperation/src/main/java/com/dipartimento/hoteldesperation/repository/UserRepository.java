package com.dipartimento.hoteldesperation.repository;

import com.dipartimento.hoteldesperation.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utente, String> {

    // Controlla se un utente con la stessa email esiste già nel database
    boolean existsByEmail(String email);
}