package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UscitaRepository extends JpaRepository<Uscita, Long> {
    List<Uscita> findByCategoriaSpesa_Id(Long idCategoria);

    List<Uscita> findByDescrizioneContaining(String descrizione);

    List<Uscita> findByDataSpesaBetween(Date start, Date end);
}
