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

    @GetMapping("/page")
    public ResponseEntity<Page<EntrataDTO>> getPaginaEntrate(
            @RequestParam(defaultValue = "0") @Min(0) int numeroPagina,
            @RequestParam(defaultValue = "10") @Min(1) int quantitaPagina,
            @RequestParam(defaultValue = "dataEntrata") @Pattern(regexp = "dataEntrata|importo") String campo,
            @RequestParam(defaultValue = "desc") @Pattern(regexp = "asc|desc") String ordine
    ) {
        Page<EntrataDTO> entrataDTOPage = entrataService.getAllEntratePaginateOrderBy(numeroPagina, quantitaPagina, campo, ordine);

        return entrataDTOPage.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(entrataDTOPage);
    }
}
