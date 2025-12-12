package com.example.backend_my_web_portafoglio.model.dto;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object nato dall'unione delle entità {@link Uscita} e {@link Entrata}.
 * Utilizzato per trasferire i dati tra i vari livelli dell'app senza esporre le entità originali.
 */
public class AllTransactionDTO {
    /**
     * Identificativo univoco della transazione, corrispondente all'ID dell'entità di origine ({@link Entrata} o {@link Uscita}).
     */
    private Long id;

    /**
     * Importo in entrata o in uscita della transazione.
     */
    private BigDecimal importo;

    /**
     * Descrizione della transazione.
     */
    private String descrizione;

    /**
     * Data in cui è avvenuta la transazione.
     */
    private Date data;

    /**
     * Categoria associata alla transazione.
     *
     * È valorizzata solo nel caso di una {@link Uscita}
     * vale {@code null} se la transazione è una {@link Entrata}.
     */
    private String categoria;

    /**
     * Indica se la transazione è un'entrata o un'uscita.
     */
    private TipoTransazione tipo;

    /**
     * Costruttore vuoto per inizializzare il DTO senza valori.
     */
    public AllTransactionDTO() {
    }

    ;

    /**
     * Costruttore usato per inizializzare il DTO con tutti i valori disponibili.
     *
     * @param id          identificativo univoco
     * @param importo     importo della transazione
     * @param descrizione descrizione associata alla transazione
     * @param data        data in cui è avvenuta o è stata registrata la transazione
     * @param categoria   categoria della transazione
     * @param tipo        tipo di transazione
     */
    public AllTransactionDTO(Long id, BigDecimal importo, String descrizione, Date data, String categoria, TipoTransazione tipo) {
        this.id = id;
        this.importo = importo;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.tipo = tipo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
