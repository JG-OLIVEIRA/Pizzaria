package com.sensedia.sensezzaria.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;

    private Double total;

    List<Alimento> alimentos = new ArrayList<>();

    public Pedido(){}

    public Pedido(Long id, Double total) {
        this.id = id;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void adicionaAlimento(Alimento alimento){
        alimentos.add(alimento);
    }

    public void removeAlimento(Integer index) {
        alimentos.remove(alimentos.get(index));
    }

    public Double getValorTotal() {
        this.setTotal(this.alimentos.stream().mapToDouble(Alimento::getValor).sum());
        return this.total;
    }
}