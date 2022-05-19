package com.sensezzaria.entidades;

public class Sobremesa extends Alimento{
    private String nome;

    public Sobremesa(Long id, String nome, Float valor){
        this.setId(id);
        this.nome = nome;
        this.setValor(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
