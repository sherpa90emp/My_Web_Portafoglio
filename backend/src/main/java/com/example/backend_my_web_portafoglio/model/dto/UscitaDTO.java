package com.example.backend_my_web_portafoglio.model.dto;

import com.example.backend_my_web_portafoglio.model.entity.Uscita;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object dell'entità {@link Uscita}.
 * Utilizzato per trasferire i dati tra i vari livelli dell'app senza esporre l'entità.
 */
public class UscitaDTO {
    /**
     * ID univoco dell'uscita, corrisponde al campo {@code id_spesa} dell'entità.
     */
    private Long id;

    /**
     * Data in cui è avvenuta la registrazione o è stato effettuato il pagamento dell'importo della spesa.
     */
    private Date dataSpesa;

    /**
     * Importo associato all'uscita.
     */
    private BigDecimal importo;

    /**
     * Descrizione dell'importo della relativa spesa.
     */
    private String descrizione;

    /**
     * Categoria a cui appartiene la relativa spesa.
     */
    private String categoriaSpesa;

    /**
     * Costruttore vuoto per inizializzare il DTO senza valori.
     */
    public UscitaDTO() {
    }

    /**
     * Costruttore usato per inizializzare il DTO con tutti i valori disponibili.
     *
     * @param id             identificativo dell'uscita
     * @param dataSpesa      Data in cui è avvenuta la registrazione o è stato effettuato il pagamento
     * @param importo        importo dell'uscita
     * @param descrizione    descrizione del pagamento effettuato
     * @param categoriaSpesa categoria della spesa
     */
    public UscitaDTO(Long id, Date dataSpesa, BigDecimal importo, String descrizione, String categoriaSpesa) {
        this.id = id;
        this.dataSpesa = dataSpesa;
        this.importo = importo;
        this.descrizione = descrizione;
        this.categoriaSpesa = categoriaSpesa;
    }

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

    public String getCategoriaSpesa() {
        return categoriaSpesa;
    }

    public void setCategoriaSpesa(String categoriaSpesa) {
        this.categoriaSpesa = categoriaSpesa;
    }
}
