package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.UscitaMapper;
import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.repository.UscitaRepository;
import org.springframework.stereotype.Service;

import com.example.backend_my_web_portafoglio.model.entity.Uscita;

import java.util.Date;
import java.util.List;

/**
 * Service responsabile della business logic delle operazioni legate alle {@link Uscita}.
 * Fornisce metodi per manipolare e recuperare i dati relativi alle uscite.
 */
@Service
public class UscitaService {
    private final UscitaRepository uscitaRepository;
    private final UscitaMapper uscitaMapper;

    /**
     * Costruttore per inizializzare il servizio con le dipendenze necessarie.
     *
     * @param uscitaRepository che gestisce l'accesso ai dati delle uscite.
     * @param uscitaMapper     mapper che permette la conversione dell'entità Uscita in DTO e viceversa.
     */
    public UscitaService(UscitaRepository uscitaRepository, UscitaMapper uscitaMapper) {
        this.uscitaRepository = uscitaRepository;
        this.uscitaMapper = uscitaMapper;
    }

    /**
     * Recupera tutte le uscite presenti e le converte in DTO.
     *
     * @return lista contenente tutte le {@link UscitaDTO}.
     */
    public List<UscitaDTO> getAll() {
        return uscitaRepository.findAll()
                .stream()
                .map(uscitaMapper::toDTO)
                .toList();
    }

    /**
     * Recupera tutte le uscite comprese in uno specifico intervallo di tempo e le converte in DTO.
     *
     * @param dataInizio data di inizio intervallo
     * @param dataFine   data di fine intervallo
     * @return lista contenente le {@link UscitaDTO} comprese nell'intervallo di tempo.
     */
    public List<UscitaDTO> findByDataSpesaBetween(Date dataInizio, Date dataFine) {
        return uscitaRepository.findByDataSpesaBetween(dataInizio, dataFine)
                .stream()
                .map(uscitaMapper::toDTO)
                .toList();
    }
}
