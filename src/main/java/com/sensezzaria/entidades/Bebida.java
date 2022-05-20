package com.sensezzaria.entidades;

public class Bebida extends Alimento{
    private String nome;
    private Float medida;

    public Bebida(Long id, String nome, Float medida, Float valor){
        this.setId(id);
        this.nome = nome;
        this.medida = medida;
        this.setValor(valor);
    }

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

    @Override
    public String toString() {
        return "[Bebida: " +  "Id: " + getId() + ", nome: " + getNome() + ", medida: " + getMedida() + ", valor: R$" + getValor() + "]";
    }

}
