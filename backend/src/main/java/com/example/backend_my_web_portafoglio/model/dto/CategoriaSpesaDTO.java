package com.example.backend_my_web_portafoglio.model.dto;

import com.example.backend_my_web_portafoglio.model.entity.CategoriaSpesa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Data Transfer Object dell'entità {@link CategoriaSpesa}.
 * Utilizzato per trasferire dati tra i vari livelli dell'app senza esporre l'entità.
 */
public class CategoriaSpesaDTO {
    /**
     * ID univoco della categoria di spesa, corrispondente al campo dell'entità {@code id_categoria}.
     */
    @NotNull(message = "L'id è obbligatorio")
    @Positive
    private Long id;

    /**
     * Nome della categoria.
     */
    @NotBlank(message = "Necessario specificare la categoria")
    private String categoria;

    /**
     * Costruttore vuoto per inizializzare il DTO senza valori.
     */
    public CategoriaSpesaDTO() {
    }

    /**
     * Costruttore usato per inizializzare il DTO con tutti i valori disponibili.
     *
     * @param id identificativo della categoria di spesa
     * @param categoria nome della categoria
     */
    public CategoriaSpesaDTO(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

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
}
