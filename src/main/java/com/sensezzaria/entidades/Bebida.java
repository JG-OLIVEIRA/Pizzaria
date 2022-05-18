package com.sensezzaria.entidades;

public class Bebida extends Alimento{
    private String nome;
    private Float medida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getMedida() {
        return medida;
    }

    public void setMedida(Float medida) {
        this.medida = medida;
    }

}
