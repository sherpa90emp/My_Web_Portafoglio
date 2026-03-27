package com.example.backend_my_web_portafoglio.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vista_movimenti")
@Immutable
public class Movimento {
    /**
     * Identificativo univoco della transazione.
     * Mappa la colonna {@code id_univoco}.
     */
    @Id
    @Column(name = "id_univoco")
    private String id;

    /**
     * Data in cui è stata effettuata/registrata la transazione.
     * Mappa la colonna {@code data}.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    /**
     * Importo della transazione.
     */
    private BigDecimal importo;

    /**
     * Descrizione della transazione, utile per specificare la natura o la provenienza della transazione.
     */
    private String descrizione;

    /**
     * Categoria della transazione, utile per capire la natura della spesa effettuata.
     */
    private String categoria;

    /**
     * Tipo della transazione, utile per capire se è una spesa o un'entrata.
     */
    private String tipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
