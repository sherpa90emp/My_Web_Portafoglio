package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.model.entity.CategoriaSpesa;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import org.springframework.stereotype.Component;

@Component
public class UscitaMapper {

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
