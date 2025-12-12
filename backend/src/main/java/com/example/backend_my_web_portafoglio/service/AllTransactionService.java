package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import com.example.backend_my_web_portafoglio.model.dto.AllTransactionDTO;
import com.example.backend_my_web_portafoglio.model.dto.TipoTransazione;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Service responsabile della business logic delle operazioni legate al DTO {@link AllTransactionDTO}.
 * Fornisce metodi per manipolare e recuperare i dati relativi a tutte le transazioni.
 */
@Service
public class AllTransactionService {
    private final EntrataService entrataService;
    private final UscitaService uscitaService;

    /**
     * Costruttore per inizializzare il servizio con le dipendenze necessarie.
     *
     * @param entrataService business logic della entità {@link Entrata}
     * @param uscitaService  business logic della entità {@link Uscita}
     */
    public AllTransactionService(EntrataService entrataService, UscitaService uscitaService) {
        this.entrataService = entrataService;
        this.uscitaService = uscitaService;
    }

    /**
     * Recupera tutte le entrate e le uscite presenti nel DB.
     * Le unisce in un unica lista ordinata per data decrescente.
     *
     * @return una lista contenente tutte le transazioni.
     */
    public List<AllTransactionDTO> getAllTransaction() {
        List<AllTransactionDTO> entrate = entrataService.getAllEntrate()
                .stream()
                .map(e -> new AllTransactionDTO(
                        e.getId(),
                        e.getImporto(),
                        e.getDescrizione(),
                        e.getDataEntrata(),
                        null,
                        TipoTransazione.ENTRATA
                ))
                .toList();

        List<AllTransactionDTO> uscite = uscitaService.getAllUscite()
                .stream()
                .map(u -> new AllTransactionDTO(
                        u.getId(),
                        u.getImporto(),
                        u.getDescrizione(),
                        u.getDataSpesa(),
                        u.getCategoriaSpesa(),
                        TipoTransazione.USCITA
                ))
                .toList();

        return Stream.concat(entrate.stream(), uscite.stream())
                .sorted(Comparator.comparing(AllTransactionDTO::getData).reversed())
                .toList();
    }
}
