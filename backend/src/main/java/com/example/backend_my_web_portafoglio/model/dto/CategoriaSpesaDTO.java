package com.example.backend_my_web_portafoglio.model.dto;

public class CategoriaSpesaDTO {
    private Long id;
    private String categoria;

    public CategoriaSpesaDTO() {}

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
