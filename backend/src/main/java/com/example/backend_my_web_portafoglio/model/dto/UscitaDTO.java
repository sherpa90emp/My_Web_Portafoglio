package com.example.backend_my_web_portafoglio.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UscitaDTO {
    private Long id;
    private Date dataSpesa;
    private BigDecimal importo;
    private String descrizione;
    private String categoriaSpesa;

    private UscitaDTO() {}

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
