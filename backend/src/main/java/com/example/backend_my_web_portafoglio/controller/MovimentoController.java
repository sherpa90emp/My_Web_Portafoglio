package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.MovimentoDTO;
import com.example.backend_my_web_portafoglio.service.MovimentoService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsabile della gestione delle richieste HTTP relative alle transazioni.
 * Espone le API con percorso /api/movimento.
 */
@RestController
@RequestMapping("/api/movimento")
public class MovimentoController {
    @Autowired
    private MovimentoService movimentoService;

    /**
     * Recupera tutti i movimenti (entrate e uscite) nel db.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutti i movimenti
     * - 204 No Content se la lista è vuota, ovvero non esistono movimenti
     */
    @GetMapping
    public ResponseEntity<Page<MovimentoDTO>> getPaginaAllTransaction(
            @RequestParam(defaultValue = "0") @Min(0) int numeroPagina,
            @RequestParam(defaultValue = "10") @Min(1) int quantitaPerPagina,
            @RequestParam(defaultValue = "dataEntrata") @Pattern(regexp = "dataEntrata|importo") String campo,
            @RequestParam(defaultValue = "desc") @Pattern(regexp = "asc|desc") String ordine
    ) {
        Page<MovimentoDTO> movimentoDTOPage = movimentoService.getMovimentoPaginate(numeroPagina, quantitaPerPagina, campo, ordine);

        return movimentoDTOPage.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(movimentoDTOPage);
    }
}
