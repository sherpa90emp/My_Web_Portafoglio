package com.example.backend_my_web_portafoglio.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorie_spesa")
public class CategoriaSpesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome_categoria")
    private String categoria;

    @OneToMany(mappedBy = "categoriaSpesa")
    @JsonBackReference("spese_effettuate-categorie_spesa")
    private List<Uscita> uscite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Uscita> getUscite() {
        return uscite;
    }

    public void setUscite(List<Uscita> uscite) {
        this.uscite = uscite;
    }
}
