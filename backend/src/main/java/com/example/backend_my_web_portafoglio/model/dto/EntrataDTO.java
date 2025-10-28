package com.example.backend_my_web_portafoglio.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EntrataDTO {
    private Long id;
    private BigDecimal importo;
    private String descrzione;
    private Date dataEntrata;

    public EntrataDTO() {}

    public EntrataDTO(Long id, BigDecimal importo, String descrzione, Date dataEntrata) {
        this.id = id;
        this.importo = importo;
        this.descrzione = descrzione;
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

    public String getDescrzione() {
        return descrzione;
    }

    public void setDescrzione(String descrzione) {
        this.descrzione = descrzione;
    }

    public Date getDataEntrata() {
        return dataEntrata;
    }

    public void setDataEntrata(Date dataEntrata) {
        this.dataEntrata = dataEntrata;
    }
}
