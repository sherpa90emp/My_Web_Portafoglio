package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.service.EntrataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
     * Recupera tutte le entrate nel db in ordine decrescente secondo la data.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista ordinata di tutte le entrate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping("/dataEntrata/desc")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrderByDataDesc() {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrateOrderByDataDesc();
        if (entrateDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }

    /**
     * Recupera tutte le entrate nel db in ordine ascendente secondo la data.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista ordinata di tutte le entrate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping("/dataEntrata/asc")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrderByDataAsc() {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrateOrderByDataAsc();
        if (entrateDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }

    /**
     * Recupera tutte le entrate nel db in ordine decrescente secondo l'importo.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista ordinata di tutte le entrate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping("/importo/desc")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrderByImportoDesc() {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrateOrderByImportoDesc();
        if (entrateDTO.isEmpty()) ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }

    /**
     * Recupera tutte le entrate nel db in ordine ascendente secondo l'importo.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista ordinata di tutte le entrate
     * - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping("/importo/asc")
    public ResponseEntity<List<EntrataDTO>> getAllEntrateOrderByImportoAsc() {
        List<EntrataDTO> entrateDTO = entrataService.getAllEntrateOrderByImportoAsc();
        if (entrateDTO.isEmpty()) ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }
}
