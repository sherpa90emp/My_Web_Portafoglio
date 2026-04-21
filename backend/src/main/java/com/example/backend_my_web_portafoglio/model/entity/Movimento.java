package com.example.backend_my_web_portafoglio.model.entity;

import com.example.backend_my_web_portafoglio.model.enums.TipoTransazione;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vista_movimenti")
@Immutable
public class Movimento {
    /**
     * Identificativo univoco del movimento.
     * Mappa la colonna {@code id_univoco}.
     */
    @Id
    @Column(name = "id_univoco")
    private String id;

    /**
     * Data in cui è stata effettuato/registrato il movimento.
     * Mappa la colonna {@code data}.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    /**
     * Importo del movimento.
     */
    private BigDecimal importo;

    /**
     * Descrizione del movimento, utile per specificare la natura o la provenienza del movimento.
     */
    private String descrizione;

    /**
     * Categoria del movimento, utile per capire la natura della spesa effettuata.
     */
    private String categoria;

    /**
     * Tipo del movimento, utile per capire se è una spesa o un'entrata.
     */
    private TipoTransazione tipo;

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

    public TipoTransazione getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransazione tipo) {
        this.tipo = tipo;
    }
}
