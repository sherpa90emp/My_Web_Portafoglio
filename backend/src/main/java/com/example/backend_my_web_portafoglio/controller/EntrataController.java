package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.service.EntrataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsabile della gestione delle richieste HTTP relative alle entrate.
 * Espone le API con percorso /api/entrate.
 */
@RestController
@RequestMapping("/api/entrate")
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
     * - 400 Bad Request se il mapping è errato
     */
    @GetMapping("/{campo}/{ordine}")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrder(
            @PathVariable String campo,
            @PathVariable String ordine
    ) {
        List<EntrataDTO> entrateDTO;

        boolean asc = "asc".equalsIgnoreCase(ordine);
        boolean desc = "desc".equalsIgnoreCase(ordine);

        if (!asc && !desc) return ResponseEntity.badRequest().build();

        switch (campo) {
            case "dataEntrata":
                if (asc) {
                    entrateDTO = entrataService.getAllEntrateOrderByDataAsc();
                } else {
                    entrateDTO = entrataService.getAllEntrateOrderByDataDesc();
                }
                break;
            case "importo":
                if (asc) {
                    entrateDTO = entrataService.getAllEntrateOrderByImportoAsc();
                } else {
                    entrateDTO = entrataService.getAllEntrateOrderByImportoDesc();
                }
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        if (entrateDTO.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(entrateDTO);
    }
}
