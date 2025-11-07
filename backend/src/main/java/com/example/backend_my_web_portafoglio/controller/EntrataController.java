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

@RestController
@RequestMapping("/api/entrate")
public class EntrataController {
    @Autowired
    private EntrataService entrataService;

    @GetMapping
    public ResponseEntity<List<EntrataDTO>> getAllEntrate() {
        List<EntrataDTO> entrateDTO = new ArrayList<>(entrataService.getAllEntrate());
        if (entrateDTO.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entrateDTO);
    }
}
