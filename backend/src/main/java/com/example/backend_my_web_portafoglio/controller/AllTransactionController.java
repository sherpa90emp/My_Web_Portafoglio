package com.example.backend_my_web_portafoglio.controller;

import com.example.backend_my_web_portafoglio.model.dto.AllTransactionDTO;
import com.example.backend_my_web_portafoglio.service.AllTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsabile della gestione delle richieste HTTP relative alle transazioni.
 * Espone le API con percorso /api/alltransaction.
 */
@RestController
@RequestMapping("/api/alltransaction")
public class AllTransactionController {
    @Autowired
    private AllTransactionService allTransactionService;

    /**
     * Recupera tutte le transazioni nel db.
     *
     * @return una ResponseEntity che contiene:
     * - 200 OK con la lista di tutte le transazioni
     * - 204 No Content se la lista è vuota, ovvero non esistono transazioni
     */
    @GetMapping
    public ResponseEntity<List<AllTransactionDTO>> getAllTransaction() {
        List<AllTransactionDTO> allTransactionDTO = allTransactionService.getAllTransaction();
        if (allTransactionDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(allTransactionDTO);
    }
}
