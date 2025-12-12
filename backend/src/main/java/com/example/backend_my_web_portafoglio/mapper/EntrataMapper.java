package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.EntrataDTO;
import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import org.springframework.stereotype.Component;

/**
 * Mapper responsabile della conversione tra l'entità {@link Entrata} e il relativo {@link EntrataDTO}.
 * Utilizzato per evitare di esporre direttamente l'entità verso il frontend.
 */
@Component
public class EntrataMapper {
    /**
     * Converte l'istanza di {@link Entrata} in {@link EntrataDTO}.
     *
     * @param entrata l'entità recuperata dal DB
     * @return il DTO corrispondente, oppure {@code null} se l'entità è nulla.
     */
    public EntrataDTO toDTO(Entrata entrata) {
        if (entrata == null) return null;

        return new EntrataDTO(
                entrata.getId(),
                entrata.getImporto(),
                entrata.getDescrizione(),
                entrata.getDataEntrata()
        );
    }

    /**
     * Converte l'istanza di {@link EntrataDTO} in {@link Entrata}.
     *
     * @param entrataDTO il DTO proveniente dal frontend
     * @return l'entità convertita, oppure {@code null} se il DTO è nullo.
     */
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
