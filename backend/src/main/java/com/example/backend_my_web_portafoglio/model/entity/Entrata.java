package com.example.backend_my_web_portafoglio.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Entità rappresentate una singola entrata registrata nel DB.
 * Mappa la tabella {@code entrate} del DB.
 */
@Entity
@Table(name = "entrate")
public class Entrata {

    /**
     * Identificativo univoco dell'entrata.
     * Mappa la colonna {@code id_entrata}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrate")
    private Long id;

    /**
     * Importo dell'entrata.
     */
    private BigDecimal importo;

    /**
     * Descrizione della somma ricevuta, utile per specificare la natura o la provenienza della somma ricevuta.
     */
    private String descrizione;

    /**
     * Data in cui è stata ricevuta la somma.
     * Mappa la colonna {@code data_entrata}.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrata")
    private Date dataEntrata;

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
