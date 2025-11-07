package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.EntrataMapper;
import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.repository.EntrataRepository;

import java.util.List;

public class EntrataService {
    private final EntrataRepository entrataRepository;
    private final EntrataMapper entrataMapper;

    public EntrataService(EntrataRepository entrataRepository, EntrataMapper entrataMapper) {
        this.entrataRepository = entrataRepository;
        this.entrataMapper = entrataMapper;
    }

    public List<EntrataDTO> getAllEntrate() {
        return entrataRepository.findAll()
                .stream()
                .map(entrataMapper::toDTO)
                .toList();
    }
}
