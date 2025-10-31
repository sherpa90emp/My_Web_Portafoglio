package com.example.backend_my_web_portafoglio.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "spese_effettuate")
public class Uscita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spesa")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_spesa")
    private Date dataSpesa;

    private BigDecimal importo;
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonManagedReference("spese_effettuate-categorie_spese")
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
