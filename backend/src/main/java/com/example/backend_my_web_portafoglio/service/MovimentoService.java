package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.MovimentoMapper;
import com.example.backend_my_web_portafoglio.model.entity.Movimento;
import com.example.backend_my_web_portafoglio.model.dto.MovimentoDTO;
import com.example.backend_my_web_portafoglio.repository.MovimentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Service responsabile della business logic delle operazioni legate al DTO {@link MovimentoDTO}.
 * Fornisce metodi per manipolare e recuperare i dati relativi a tutte i movimenti.
 */
@Service
public class MovimentoService {
    private final MovimentoRepository movimentoRepository;
    private final MovimentoMapper movimentoMapper;


    /**
     * Costruttore per inizializzare il servizio con le dipendenze necessarie.
     *
     * @param movimentoRepository che gestisce l'accesso ai dati dei movimenti in entrata e uscita.
     * @param movimentoMapper mapper per convertire le entità {@link Movimento}  in DTO e viceversa.
     */
    public MovimentoService(MovimentoRepository movimentoRepository, MovimentoMapper movimentoMapper) {
        this.movimentoRepository = movimentoRepository;
        this.movimentoMapper = movimentoMapper;
    }

    /**
     * Recupera tutte le entrate e le uscite presenti nel DB.
     * Le unisce in un unica lista ordinata per data decrescente.
     *
     * @return una lista contenente tutti i movimenti.
     */
    public Page<MovimentoDTO> getMovimentoPaginate(int numeroPagina, int quantitaPagina, String campo, String ordine) {
        Sort sort = ordine.equalsIgnoreCase("asc")
                ? Sort.by(campo).ascending()
                : Sort.by(campo).descending();

        Pageable pageable = PageRequest.of(numeroPagina, quantitaPagina, sort);

        return movimentoRepository.findAll(pageable)
                .map(movimentoMapper::toDTO);
    }
}
