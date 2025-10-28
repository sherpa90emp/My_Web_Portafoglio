package com.example.backend_my_web_portafoglio.mapper;

import com.example.backend_my_web_portafoglio.model.dto.CategoriaSpesaDTO;
import com.example.backend_my_web_portafoglio.model.dto.UscitaDTO;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import org.springframework.stereotype.Component;

@Component
public class UscitaMapper {

    public UscitaDTO toDTO(Uscita uscita) {
        if (uscita == null) return null;

        String categoriaSpesa = uscita.getCategoriaSpesa().getCategoria();

        return new UscitaDTO(
                uscita.getId(),
                uscita.getDataSpesa(),
                uscita.getImporto(),
                uscita.getDescrizione(),
                categoriaSpesa
        );
    }

//    public Uscita toEntita(UscitaDTO uscitaDTO, CategoriaSpesaDTO categoriaSpesaDTO) {
//        if (uscitaDTO == null) return null;
//
//        Uscita uscita = new Uscita();
//
//        uscita.setId();
//    }
}
