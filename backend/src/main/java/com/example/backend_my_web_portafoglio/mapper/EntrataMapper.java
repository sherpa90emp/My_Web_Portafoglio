package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import org.springframework.stereotype.Component;

@Component
public class EntrataMapper {
    public EntrataDTO toDTO(Entrata entrata) {
        if (entrata == null) return null;

        return new EntrataDTO(
                entrata.getId(),
                entrata.getImporto(),
                entrata.getDescrizione(),
                entrata.getDataEntrata()
        );
    }

    public Entrata toEntita(EntrataDTO entrataDTO) {
        if (entrataDTO == null) return null;

        Entrata entrata = new Entrata();

        entrata.setId(entrataDTO.getId());
        entrata.setImporto(entrataDTO.getImporto());
        entrata.setDescrizione(entrataDTO.getDescrizione());
        entrata.setDataEntrata(entrataDTO.getDataEntrata());
        return entrata;
    }
}
