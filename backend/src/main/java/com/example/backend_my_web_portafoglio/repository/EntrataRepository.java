package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EntrataRepository extends JpaRepository<Entrata, Long> {
    List<Entrata> findByDescrizioneContaining(String descrizione);

    List<Entrata> findByDataEntrataBetween(Date start, Date end);

    List<Entrata> findAllByOrderByDataEntrataAsc();

    @Query("SELECT SUM(e.importo) FROM Entrata e")
    BigDecimal getSommaTotaleImportiEntrate();
}
