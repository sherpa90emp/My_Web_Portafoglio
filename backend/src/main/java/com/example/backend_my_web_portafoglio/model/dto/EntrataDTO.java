package com.example.backend_my_web_portafoglio.model.dto;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object dell'entità {@link Entrata}.
 * Utilizzato per trasferire dati tra i vari livelli dell'app senza esporre l'entità.
 */
public class EntrataDTO {
    /**
     * ID univoco dell'entrata, corrispondente al campo {@code id_entrate} dell'entità.
     */
    @Positive
    private Long id;

    /**
     * Importo associato all'entrata.
     */
    @PositiveOrZero(message = "L'importo deve essere positivo")
    private BigDecimal importo;

    /**
     * Descrizione dell'importo della relativa entrata.
     */
    private String descrizione;

    /**
     * Data in cui è avvenuta la ricezione o la registrazione dell'importo dell'entrata.
     */
    @NotNull(message = "La data è obbligatoria")
    @PastOrPresent(message = "La data non può essere nel futuro")
    private Date dataEntrata;

    /**
     * Costruttore vuoto per inizializzare il DTO senza valori.
     */
    public EntrataDTO() {
    }

    /**
     * Costruttore usato per inizializzare il DTO con tutti i valori disponibili.
     *
     * @param id identificativo dell'entrata
     * @param importo importo ricevuto
     * @param descrizione descrizione relativa all'entrata ricevuta
     * @param dataEntrata data in cui è avvenuta la ricezione o registrazione dell'entrata
     */
    public EntrataDTO(Long id, BigDecimal importo, String descrizione, Date dataEntrata) {
        this.id = id;
        this.importo = importo;
        this.descrizione = descrizione;
        this.dataEntrata = dataEntrata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataEntrata() {
        return dataEntrata;
    }

    public void setDataEntrata(Date dataEntrata) {
        this.dataEntrata = dataEntrata;
    }
}
