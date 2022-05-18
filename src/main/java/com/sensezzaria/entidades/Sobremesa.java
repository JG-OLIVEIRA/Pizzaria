package com.sensezzaria.entidades;

import com.sensezzaria.interfaces.Alimento;

public class Sobremesa implements Alimento {
    private Long id;
    private String nome;
    private Float valor;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public Float getValor() {
        return this.valor;
    }
}
