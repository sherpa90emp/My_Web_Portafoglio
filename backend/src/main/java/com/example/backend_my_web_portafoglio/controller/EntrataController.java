package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.service.EntrataService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsabile della gestione delle richieste HTTP relative alle entrate.
 * Espone le API con percorso /api/entrate.
 */
@RestController
@RequestMapping("/api/entrate")
@Validated
public class EntrataController {
    @Autowired
    private EntrataService entrataService;

    /**
     * Recupera tutte le entrate nel db.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le entrate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping
    public ResponseEntity<List<EntrataDTO>> getAllEntrate() {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrate();
        if (entrateDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }

    /**
     * Recupera tutte le entrate nel db ordinate in base a un campo e a una direzione specifica.
     *
     * @param campo il campo su cui ordinare le entrate
     *              Valori ammessi: {@code dataEntrata}, {@code importo}
     * @param ordine la direzione di ordinamento
     *               Valori ammessi: {@code asc}, {@code desc}
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le entrate ordinate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     * - 400 Bad Request se il campo o la direzione di ordinamento non sono tra quelli permessi.
     */
    @GetMapping("/{campo}/{ordine}")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrder(
            @PathVariable @Pattern(regexp = "dataEntrata|importo") String campo,
            @PathVariable @Pattern(regexp = "asc|desc") String ordine
    ) {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrateOrderBy(campo, ordine);

        return entrateDTO.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(entrateDTO);
    }

    /**
     * Recupera una pagina di entrate dal db, ordinate per data decrescente.
     *
     * @param numeroPagina l'indice della pagina da recuperare
     * @param quantitaPerPagina il numero massimo di elementi per pagina.
     * @return una ResponseEntity che contiene:
     * - 200 OK con la pagina contenente le entrate
     * - 400 Bad Request se i parametri di paginazione non sono validi
     * - 204 No Content se la pagina è vuota, ovvero non ci sono entrate
     */
    @GetMapping("/page")
    public ResponseEntity<Page<EntrataDTO>> getPaginaEntrate(
            @RequestParam(defaultValue = "0") @Min(0) int numeroPagina,
            @RequestParam(defaultValue = "10") @Min(1) int quantitaPerPagina
    ) {
        Page<EntrataDTO> entrataDTOPage = entrataService.getAllEntrateOrderByDataDescPaginate(numeroPagina, quantitaPerPagina);
        if (entrataDTOPage.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrataDTOPage);
    }
}
