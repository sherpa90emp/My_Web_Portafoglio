package com.example.backend_my_web_portafoglio.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entrate")
public class Entrata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrate")
    private Long id;

    private Double importo;
    private String descrizione;

    @Column(name = "data_entrata")
    private Date dataEntrata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
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
