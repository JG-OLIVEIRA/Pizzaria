package com.sensezzaria.funcionalidades;

import java.util.List;

import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Cardapio {
    private List<Bebida> bebidas;
    private List<Pizza> pizzas;
    private List<Sobremesa> sobremesas;

    public Cardapio(List<Bebida> bebidas, List<Pizza> pizzas, List<Sobremesa> sobremesas){
        this.bebidas = bebidas;
        this.pizzas = pizzas;
        this.sobremesas = sobremesas;
    }

    public List<Bebida> getBebidas(){
        return this.bebidas;
    }

    public List<Pizza> getPizzas(){
        return this.pizzas;
    }

    public List<Sobremesa> getSobremesas(){
        return this.sobremesas;
    }
}
