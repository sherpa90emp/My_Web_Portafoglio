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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/uscite")
public class UscitaController {
    @Autowired
    private UscitaService uscitaService;

    @GetMapping
    public ResponseEntity<List<UscitaDTO>> getAllUscite() {
        List<UscitaDTO> usciteDTO = new ArrayList<>(uscitaService.getAll());
        if (usciteDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usciteDTO);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<UscitaDTO>> getUsciteDataBetween(
            @RequestParam("inizio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
            @RequestParam("fine") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine) {
        List<UscitaDTO> usciteDTO = new ArrayList<>(uscitaService.findByDataSpesaBetween(dataInizio, dataFine));
        if (usciteDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usciteDTO);
    }
}
