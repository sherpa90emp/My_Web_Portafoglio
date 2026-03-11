package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.EntrataMapper;
import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.repository.EntrataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service responsabile della business logic delle operazioni legate all'entità {@link Entrata}.
 * Fornisce metodi per manipolare e recuperare i dati relativi alle entrate.
 */
@Service
public class EntrataService {
    private final EntrataRepository entrataRepository;
    private final EntrataMapper entrataMapper;

    /**
     * Costruttore per inizializzare il servizio con le dipendenze necessarie.
     *
     * @param entrataRepository che gestisce l'accesso ai dati delle entrate
     * @param entrataMapper     mapper per convertire le entità Entrata in DTO e viceversa
     */
    public EntrataService(EntrataRepository entrataRepository, EntrataMapper entrataMapper) {
        this.entrataRepository = entrataRepository;
        this.entrataMapper = entrataMapper;
    }

    /**
     * Recupera tutte le entrate presenti e le converte in DTO.
     *
     * @return una lista di {@link EntrataDTO} contenente tutte le entrate disponibili.
     */
    public List<EntrataDTO> getAllEntrate() {
        return entrataRepository.findAll()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    }

    /**
     * Recupera la somma di tutte le entrate presenti nel DB.
     *
     * @return un {@code BigDecimal} rappresentante la somma totale degli importi;
     * può essere {@code null} se non sono presenti entrate.
     */
    public BigDecimal getSommaTotaleEntrate() {
        return entrataRepository.getSommaTotaleImportiEntrate();
    }

    /**
     * Recupera una pagina di entrate ordinate in base ai parametri forniti.
     *
     * @param numeroPagina l'indice della pagina da recuperare
     * @param quantitaInPagina il numero massimo di elementi per pagina
     * @param campo il parametro sulla base del quale effettuare l'ordinamento
     * @param ordine direzione dell'ordinamento, può essere ascendente o decrescente
     * @return una {@code Page} di {@link EntrataDTO} mappata dell'entità
     */
    public Page<EntrataDTO> getAllEntratePaginateOrderBy(int numeroPagina, int quantitaInPagina, String campo, String ordine) {
        Sort sort = ordine.equalsIgnoreCase("asc")
                ? Sort.by(campo).ascending()
                : Sort.by(campo).descending();

        Pageable pageable = PageRequest.of(numeroPagina, quantitaInPagina, sort);

        return entrataRepository.findAll(pageable)
                .map(entrataMapper::toDTO);
    }
}
