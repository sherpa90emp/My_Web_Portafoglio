package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.UscitaMapper;
import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.repository.UscitaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
     * @param uscitaRepository che gestisce l'accesso ai dati delle uscite
     * @param uscitaMapper     mapper che permette la conversione dell'entità Uscita in DTO e viceversa
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
    public List<UscitaDTO> getAllUscite() {
        return uscitaRepository.findAll()
                .stream()
                .map(uscitaMapper::toDTO)
                .toList();
    }

    /**
     * Recupera una pagina di uscite ordinate in base ai parametri forniti.
     *
     * @param numeroPagina l'indice della pagina da recuperare
     * @param quantitaInPagina il numero massimo di elementi per pagina
     * @param campo il parametro sulla base del quale effettuare l'ordinamento
     * @param ordine direzione dell'ordinamento, può essere ascendente o decrescente
     * @return una {@code Page} di {@link UscitaDTO} mappata dell'entità {@link Uscita}
     */
    public Page<UscitaDTO> getAllUscitePaginateOrderBy(int numeroPagina, int quantitaInPagina, String campo, String ordine) {
        Sort sort = ordine.equalsIgnoreCase("asc")
                ? Sort.by(campo).ascending()
                : Sort.by(campo).descending();

        Pageable pageable = PageRequest.of(numeroPagina, quantitaInPagina, sort);

        return uscitaRepository.findAll(pageable)
                .map(uscitaMapper::toDTO);
    }
}
