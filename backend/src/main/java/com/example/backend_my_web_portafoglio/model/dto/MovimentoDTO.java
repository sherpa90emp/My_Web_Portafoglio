package com.example.backend_my_web_portafoglio.model.dto;

import com.example.backend_my_web_portafoglio.model.entity.Entrata;
import com.example.backend_my_web_portafoglio.model.entity.Uscita;
import com.example.backend_my_web_portafoglio.model.enums.TipoTransazione;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object nato dall'unione delle entità {@link Uscita} e {@link Entrata}.
 * Utilizzato per trasferire i dati tra i vari livelli dell'app senza esporre le entità originali.
 */
public class MovimentoDTO {
    /**
     * Identificativo univoco della transazione, corrispondente all'ID dell'entità di origine ({@link Entrata} o {@link Uscita}).
     */
    @Positive
    private String id;

    /**
     * Importo in entrata o in uscita del movimento.
     */
    @NotNull(message = "L'importo è obbligatorio")
    @PositiveOrZero(message = "L'importo deve essere positivo")
    private BigDecimal importo;

    /**
     * Descrizione del movimento.
     */
    private String descrizione;

    /**
     * Data in cui è avvenuto il movimento.
     */
    @NotNull(message = "La data è obbligatoria")
    @PastOrPresent(message = "La data non può essere nel futuro")
    private Date data;

    /**
     * Categoria associata al movimento.
     *
     * È valorizzata solo nel caso di una {@link Uscita} vale {@code null} se la transazione è una {@link Entrata}.
     */
    private String categoria;

    /**
     * Indica se il movimento è un'entrata o un'uscita.
     */
    @NotBlank(message = "Necessario specificare il tipo di transazione")
    private TipoTransazione tipo;

    /**
     * Costruttore vuoto per inizializzare il DTO senza valori.
     */
    public MovimentoDTO() {
    }

    ;

    /**
     * Costruttore usato per inizializzare il DTO con tutti i valori disponibili.
     *
     * @param id          identificativo univoco
     * @param importo     importo del movimento
     * @param descrizione descrizione associata al movimento
     * @param data        data in cui è avvenuto o è stato registrato il movimento
     * @param categoria   categoria del movimento
     * @param tipo        tipo di movimento
     */
    public MovimentoDTO(String id, BigDecimal importo, String descrizione, Date data, String categoria, TipoTransazione tipo) {
        this.id = id;
        this.importo = importo;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
