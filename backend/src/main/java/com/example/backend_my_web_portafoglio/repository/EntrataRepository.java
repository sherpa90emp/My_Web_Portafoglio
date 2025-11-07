package com.example.backend_my_web_portafoglio.repository;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EntrataRepository extends JpaRepository<Entrata, Long> {
    List<Entrata> findByDescrizioneContaining(String descrizione);

    List<Entrata> findByDataEntrataBetween(Date start, Date end);
}
