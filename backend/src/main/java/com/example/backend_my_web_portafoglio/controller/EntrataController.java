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
     *      - 200 OK con la lista di tutte le entrate
     *      - 204 No Content se la lista è vuota, ovvero non esistono entrate
     */
    @GetMapping
    public ResponseEntity<List<EntrataDTO>> getAllEntrate() {
        List<EntrataDTO> entrateDTO = new ArrayList<>(entrataService.getAllEntrate());
        if (entrateDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }
}
