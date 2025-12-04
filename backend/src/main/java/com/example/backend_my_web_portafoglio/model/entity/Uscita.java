package com.example.backend_my_web_portafoglio.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Entità rappresentante la singola uscita registrata sul DB.
 * Mappa la tabella {@code spese_effettuate} del DB.
 */
@Entity
@Table(name = "spese_effettuate")
public class Uscita {
    /**
     * Identificativo univoco della spesa.
     * Mappa la colonna {@code id_spesa}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spesa")
    private Long id;

    /**
     * Data in cui è stata effettuata/registrata la spesa.
     * Mappa la colonna {@code data_spesa}.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "data_spesa")
    private Date dataSpesa;

    /**
     * Importo della spesa.
     */
    private BigDecimal importo;

    /**
     * Descrizione della spesa, utile per specificare la natura o la provenienza della spesa effettuata.
     */
    private String descrizione;

    /**
     * Identifica a che tipo di categoria appartiene la spesa effettuata.
     * Relazione molti a uno con l'entità {@code CategoriaSpesa}.
     * Mappa la colonna {@code id_categoria}.
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonManagedReference("spese_effettuate-categorie_spesa")
    private CategoriaSpesa categoriaSpesa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSpesa() {
        return dataSpesa;
    }

    public void setDataSpesa(Date dataSpesa) {
        this.dataSpesa = dataSpesa;
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

    public CategoriaSpesa getCategoriaSpesa() {
        return categoriaSpesa;
    }

    public void setCategoriaSpesa(CategoriaSpesa categoriaSpesa) {
        this.categoriaSpesa = categoriaSpesa;
    }
}
