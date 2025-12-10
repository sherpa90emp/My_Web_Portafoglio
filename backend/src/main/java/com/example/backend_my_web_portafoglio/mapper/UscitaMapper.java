package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.model.entity.CategoriaSpesa;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import org.springframework.stereotype.Component;

/**
 * Mapper responsabile della conversione tra l'entità {@link Uscita} e il relativo DTO {@link UscitaDTO}.
 * Utilizzato per evitare di esporre direttamente l'entità verso il frontend.
 */
@Component
public class UscitaMapper {

    /**
     * Converte l'istanza di {@link Uscita} in {@link UscitaDTO}.
     *
     * @param uscita entità recuperata dal DB.
     * @return il DTO corrispondente, oppure {@code null} se l'entità è nulla.
     */
    public UscitaDTO toDTO(Uscita uscita) {
        if (uscita == null) return null;

        String categoriaSpesa = uscita.getCategoriaSpesa() != null
                ? uscita.getCategoriaSpesa().getCategoria()
                : null;

        return new UscitaDTO(
                uscita.getId(),
                uscita.getDataSpesa(),
                uscita.getImporto(),
                uscita.getDescrizione(),
                categoriaSpesa
        );
    }

    /**
     * Converte l'istanza di {@link UscitaDTO} in {@link Uscita}.
     *
     * @param uscitaDTO il DTO proveniente dal frontend.
     * @param categoriaSpesa entità {@link CategoriaSpesa} associata all'uscita.
     * @return l'entità convertita, oppure {@code null} se il DTO è nullo.
     */
    public Uscita toEntita(UscitaDTO uscitaDTO, CategoriaSpesa categoriaSpesa) {
        if (uscitaDTO == null) return null;

        Uscita uscita = new Uscita();

        uscita.setId(uscitaDTO.getId());
        uscita.setDataSpesa(uscitaDTO.getDataSpesa());
        uscita.setImporto(uscitaDTO.getImporto());
        uscita.setDescrizione(uscitaDTO.getDescrizione());
        uscita.setCategoriaSpesa(categoriaSpesa);
        return uscita;
    }
}
