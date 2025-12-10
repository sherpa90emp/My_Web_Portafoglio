package com.example.backend_my_web_portafoglio.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entità rappresentante una singola categoria di spesa registrata nel DB.
 * Mappa la tabella {@code categorie_spesa} del DB.
 */
@Entity
@Table(name = "categorie_spesa")
public class CategoriaSpesa {

    /**
     * Identificativo univoco della categoria spesa.
     * Mappa la colonna {@code id_categoria}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    /**
     * Nome del tipo di categoria di spesa.
     */
    @Column(name = "nome_categoria")
    private String categoria;

    /**
     * Relazione uno a molti con l'entità {@link Uscita}.
     * Una categoria può essere associata a più spese.
     */
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
