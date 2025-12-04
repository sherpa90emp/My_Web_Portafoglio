package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Repository responsabile dell'accesso ai dati della tabella {@code entrate}.
 * Fornisce metodi per interrogare il DB attraverso query derivate o personalizzate.
 */
public interface EntrataRepository extends JpaRepository<Entrata, Long> {
    /**
     * Recupera tutte le entrate la cui descrizione contiene una specifica stringa.
     *
     * @param descrizione parte della descrizione.
     * @return lista delle entrate che contengono la stringa nella descrizione.
     */
    List<Entrata> findByDescrizioneContaining(String descrizione);

    /**
     * Recupera tutte le entrate in uno specifico intervallo di tempo.
     *
     * @param start data di inizio intervallo.
     * @param end data di fine intervallo.
     * @return lista delle entrate che rientrano in quello specifico intervallo.
     */
    List<Entrata> findByDataEntrataBetween(Date start, Date end);

    /**
     * Recupera tutte le entrate ordinate in modo crescente in base alla data.
     *
     * @return lista di tutte le entrate ordinate secondo la lora data in ordine crescente.
     */
    List<Entrata> findAllByOrderByDataEntrataAsc();


    /**
     * Effettua una somma di tutti gli importi presenti nella tabella.
     *
     * @return un {@code BigDecimal} rappresentante la somma totale di tutti gli importi.
     */
    @Query("SELECT SUM(e.importo) FROM Entrata e")
    BigDecimal getSommaTotaleImportiEntrate();
}
