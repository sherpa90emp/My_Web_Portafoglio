package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.EntrataMapper;
import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.repository.EntrataRepository;
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
     * Recupera tutte le entrate presenti e le converte in DTO, ordinate per data in ordine crescente.
     *
     * @return una lista di {@link EntrataDTO} contenente tutte le entrate disponibili ordinate per data.
     */
    public List<EntrataDTO> getAllEntrateOrderByDataAsc() {
        return entrataRepository.findAllByOrderByDataEntrataAsc()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    }

    /**
     * Recupera tutte le entrate presenti e le converte in DTO, ordinate per data in ordine decrescente.
     *
     * @return una lista di {@link EntrataDTO} contenente tutte le entrate disponibili ordinate per data.
     */
    public List<EntrataDTO> getAllEntrateOrderByDataDesc() {
        return entrataRepository.findAllByOrderByDataEntrataDesc()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    }

    /**
     * Recupera tutte le entrate presenti e le converte in DTO, ordinate per l'importo in ordine decrescente.
     *
     * @return una lista do {@link EntrataDTO} contenente tutte le entrate disponibili ordinate per importo.
     */
    public List<EntrataDTO> getAllEntrateOrderByImportoDesc() {
        return entrataRepository.findAllByOrderByImportoDesc()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    };

    /**
     * Recupera tutte le entrate presenti e le converte in DTO, ordinate per l'importo in ordine ascendente.
     *
     * @return una lista do {@link EntrataDTO} contenente tutte le entrate disponibili ordinate per importo.
     */
    public List<EntrataDTO> getAllEntrateOrderByImportoAsc() {
        return entrataRepository.findAllByOrderByImportoAsc()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    };

    /**
     * Recupera la somma di tutte le entrate presenti nel DB.
     *
     * @return un {@code BigDecimal} rappresentante la somma totale degli importi;
     * può essere {@code null} se non sono presenti entrate.
     */
    public BigDecimal getSommaTotaleEntrate() {
        return entrataRepository.getSommaTotaleImportiEntrate();
    }
}
