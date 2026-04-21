package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.MovimentoDTO;
import com.example.backend_my_web_portafoglio.model.entity.Movimento;
import org.springframework.stereotype.Component;

/**
 * Mapper per la conversione tra oggetti Movimento (entità) e MovimentoDTO (DTO).
 * Gestisce la conversione bidirezionale tra entità e DTO per evitare duplicati di logica.
 */
@Component
public class MovimentoMapper {

    /**
     * Converte un'entità Movimento in un DTO MovimentoDTO.
     * Esegue un controllo null per evitare NullPointerException.
     *
     * @param movimento L'entità Movimento da convertire.
     * @return Il DTO MovimentoDTO corrispondente, o null se l'entità è null.
     */
    public MovimentoDTO toDTO(Movimento movimento) {
        if (movimento == null) return null;

        return new MovimentoDTO(
                movimento.getId(),
                movimento.getImporto(),
                movimento.getDescrizione(),
                movimento.getData(),
                movimento.getCategoria(),
                movimento.getTipo()
        );
    }

    /**
     * Converte un DTO MovimentoDTO in un'entità Movimento.
     * Esegue un controllo null per evitare NullPointerException.
     *
     * @param movimentoDTO Il DTO MovimentoDTO da convertire.
     * @return L'entità Movimento corrispondente, o null se il DTO è null.
     */
    public Movimento toEntita(MovimentoDTO movimentoDTO) {
        if (movimentoDTO == null) return null;

        Movimento movimento = new Movimento();

        movimento.setId(movimentoDTO.getId());
        movimento.setData(movimentoDTO.getData());
        movimento.setImporto(movimentoDTO.getImporto());
        movimento.setDescrizione(movimentoDTO.getDescrizione());
        movimento.setCategoria(movimentoDTO.getCategoria());
        movimento.setTipo(movimentoDTO.getTipo());

        return movimento;
    }
}
