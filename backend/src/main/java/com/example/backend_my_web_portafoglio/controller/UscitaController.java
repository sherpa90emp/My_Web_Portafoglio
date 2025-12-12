package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.service.UscitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
     * Recupera tutte le uscite nel db comprese in un intervallo di tempo specifico.
     *
     * @param dataInizio data di inizio dell'intervallo
     * @param dataFine   data di fine dell'intervallo
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le uscite comprese nell'intervallo di tempo
     * - 204 No Content se la lista è vuota, ovvero non esistono uscite in quell'intervallo di tempo
     */
    @GetMapping("/periodo")
    public ResponseEntity<List<UscitaDTO>> getUsciteDataBetween(
            @RequestParam("inizio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
            @RequestParam("fine") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine) {
        List<UscitaDTO> usciteDTO = uscitaService.findByDataSpesaBetween(dataInizio, dataFine);
        if (usciteDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usciteDTO);
    }
}
