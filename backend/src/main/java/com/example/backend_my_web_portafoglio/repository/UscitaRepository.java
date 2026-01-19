package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Repository responsabile dell'accesso ai dati della tabella {@code spese_effettuate}.
 * Fornisce metodi per interrogare il DB attraverso query derivate o personalizzate.
 */
public interface UscitaRepository extends JpaRepository<Uscita, Long> {
    /**
     * Recupera tutte le spese associate a una specifica categoria.
     *
     * @param idCategoria identificativo della categoria di spesa
     * @return lista di spese effettuate appartenenti alla categoria richiesta.
     */
    List<Uscita> findByCategoriaSpesa_Id(Long idCategoria);

    /**
     * Recupera tutte le spese la cui descrizione contiene una specifica stringa.
     *
     * @param descrizione parte della descrizione.
     * @return lista delle spese che contengono la stringa nella descrizione.
     */
    List<Uscita> findByDescrizioneContaining(String descrizione);

    /**
     * Recupera tutte le spese in uno specifico intervallo di tempo.
     *
     * @param start data di inizio intervallo
     * @param end   data di fine intervallo
     * @return lista di spese comprese nell'intervallo di tempo indicato.
     */
    List<Uscita> findByDataSpesaBetween(Date start, Date end);

    /**
     * Recupera tutte le uscite ordinate in modo crescente in base all'importo.
     *
     * @return lista di tutte le uscite ordinate secondo la grandezza dell'importo.
     */
    List<Uscita> findAllByOrderByImportoAsc();

    /**
     * Recupera tutte le uscite ordinate in modo decrescente in base all'importo.
     *
     * @return lista di tutte le uscite ordinate secondo la grandezza dell'importo.
     */
    List<Uscita> findAllByOrderByImportoDesc();

    /**
     * Recupera tutte le uscite ordinate in modo decrescente in base alla data.
     *
     * @return lista di tutte le uscite ordinate secondo la loro data in ordine decrescente.
     */
    List<Uscita> findAllByOrderByDataDesc();

    /**
     * Recupera tutte le uscite ordinate in modo crescente in base alla data.
     *
     * @return lista di tutte le uscite ordinate secondo la loro data in ordine crescente.
     */
    List<Uscita> findAllByOrderByDataAsc();
}
