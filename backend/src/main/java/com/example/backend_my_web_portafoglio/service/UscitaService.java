package com.example.backend_my_web_portafoglio.service;

import com.example.backend_my_web_portafoglio.mapper.UscitaMapper;
import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.repository.UscitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UscitaService {
    private final UscitaRepository uscitaRepository;
    private final UscitaMapper uscitaMapper;


    public UscitaService(UscitaRepository uscitaRepository, UscitaMapper uscitaMapper) {
        this.uscitaRepository = uscitaRepository;
        this.uscitaMapper = uscitaMapper;
    }

    public List<UscitaDTO> getAll() {
        return uscitaRepository.findAll()
                .stream()
                .map(uscitaMapper::toDTO)
                .toList();
    }
}
