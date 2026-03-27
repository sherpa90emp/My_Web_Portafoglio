package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsabile dell'accesso ai dati della view {@code movimenti}.
 * Fornisce metodi per interrogare il DB attraverso query derivate o personalizzate.
 */
public interface MovimentoRepository extends JpaRepository<Movimento, String> {
}
