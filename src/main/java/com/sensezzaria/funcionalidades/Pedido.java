package com.sensezzaria.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Pedido {
    private List<Alimento> alimentos =  new ArrayList<>();

    public void adicionaAlimento(Alimento alimento){
        alimentos.add(alimento);
    }

    public List<Alimento> getAlimentos() {
        return this.alimentos;
    }

    public Double getValorTotal() {
        return this.alimentos.stream().mapToDouble(Alimento::getValor).sum();
    }
}
