package com.sensezzaria.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import com.sensezzaria.entidades.Alimento;

public class Pedido {
    private List<Alimento> alimentos =  new ArrayList<>();

    public void adicionaAlimento(Alimento alimento){
        alimentos.add(alimento);
    }

    public void removeAlimento(Integer index) {
        alimentos.remove(alimentos.get(index));
    }

    public List<Alimento> getAlimentos() {
        return this.alimentos;
    }

    public Double getValorTotal() {
        return this.alimentos.stream().mapToDouble(Alimento::getValor).sum();
    }
}
