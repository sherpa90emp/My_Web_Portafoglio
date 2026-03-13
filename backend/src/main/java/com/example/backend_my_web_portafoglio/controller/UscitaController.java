package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.service.UscitaService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsabile della gestione delle richieste HTTP relative alle uscite.
 * Espone le API con percorso /api/uscite.
 */
@RestController
@RequestMapping("/api/uscite")
public class UscitaController {
    @Autowired
    private UscitaService uscitaService;

    /**
     * Recupera tutte le uscite nel db.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le uscite
     * - 204 No Content se la lista è vuota, ovvero non esistono uscite
     */
    @GetMapping
    public ResponseEntity<List<UscitaDTO>> getAllUscite() {
        List<UscitaDTO> usciteDTO = uscitaService.getAllUscite();
        if (usciteDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usciteDTO);
    }

    /**
     * Recupera una pagina di uscite dal db, ordinate in base ai parametri forniti.
     *
     * @param numeroPagina l'indice della pagina da recuperare
     * @param quantitaPerPagina Il numero massimo di elementi per pagina.
     * @param campo il parametro sulla base del quale effettuare l'ordinamento
     * @param ordine direzione dell'ordinamento, può essere ascendente o decrescente
     * @return una ResponseEntity che contiene:
     * - 200 OK con la pagina contenente le uscite
     * - 204 No Content se la pagina è vuota, ovvero non ci sono uscite
     */
    @GetMapping("/page")
    public ResponseEntity<Page<UscitaDTO>> getPaginaUscite(
            @RequestParam(defaultValue = "0") @Min(0) int numeroPagina,
            @RequestParam(defaultValue = "10") @Min(1) int quantitaPerPagina,
            @RequestParam(defaultValue = "dataEntrata") @Pattern(regexp = "dataEntrata|importo") String campo,
            @RequestParam(defaultValue = "desc") @Pattern(regexp = "asc|desc") String ordine
    ) {
        Page<UscitaDTO> uscitaDTOPage = uscitaService.getAllUscitePaginateOrderBy(numeroPagina, quantitaPerPagina, campo, ordine);

        return uscitaDTOPage.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(uscitaDTOPage);
    }
}
