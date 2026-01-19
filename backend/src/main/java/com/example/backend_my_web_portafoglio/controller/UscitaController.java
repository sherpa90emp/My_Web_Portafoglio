package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.service.UscitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Recupera tutte le uscite nel db ordinate in base a un campo e a una direzione specifica.
     *
     * @param campo il campo su cui ordinare le uscite
     *              Valori ammessi: {@code dataSpesa}, {@code importo}
     * @param ordine la direzione di ordinamento
     *               Valori ammessi: {@code asc}, {@code desc}
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le uscite ordinate
     * - 204 No Content se la lista è vuota, ovvero non esistono uscite
     * - 400 Bad Request se il mapping è errato
     */
    @GetMapping("/{campo}/{ordine}")
    public ResponseEntity<List<UscitaDTO>> getAllUsciteOrder(
            @PathVariable String campo,
            @PathVariable String ordine
    ) {
        List<UscitaDTO> uscitaDTO;

        boolean asc = "asc".equalsIgnoreCase(ordine);
        boolean desc = "desc".equalsIgnoreCase(ordine);

        if (!asc && !desc) return ResponseEntity.badRequest().build();

        switch (campo) {
            case "dataSpesa":
                if (asc) {
                    uscitaDTO = uscitaService.getAllUsciteOrderByDataAsc();
                } else {
                    uscitaDTO = uscitaService.getAllUsciteOrderByDataDesc();
                }
                break;
            case "importo":
                if (asc) {
                    uscitaDTO = uscitaService.getAllUsciteOrderByImportoAsc();
                } else {
                    uscitaDTO = uscitaService.getAllUsciteOrderByImportoDesc();
                }
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        if (uscitaDTO.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(uscitaDTO);
    }
}
