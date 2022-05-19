package com.sensezzaria.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Cardapio {
    private List<Bebida> bebidas = new ArrayList<>();
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Sobremesa> sobremesas = new ArrayList<>();

    public void adicionaBebida(Bebida bebida){
        this.bebidas.add(bebida);
    }

    public void adicionaPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public void adicionaSobremesa(Sobremesa sobremesa){
        this.sobremesas.add(sobremesa);
    }


    public List<Bebida> getBebidas(){
        Bebida b1 = new Bebida(1L, "Coca-coca", 0.25F, 2.5F);
        Bebida b2 = new Bebida(2L, "Coca-coca", 1F, 9F);
        Bebida b3 = new Bebida(3L, "Guaraná", 0.25F, 2.5F);
        Bebida b4 = new Bebida(4L, "Guaraná", 1F, 8.5F);
        Bebida b5 = new Bebida(5L, "Skol-Beats", 0.35F, 7F);

        this.adicionaBebida(b1);
        this.adicionaBebida(b2);
        this.adicionaBebida(b3);
        this.adicionaBebida(b4);
        this.adicionaBebida(b5);

        return this.bebidas;
    }

    public List<Pizza> getPizzas(){
        Pizza p1 = new Pizza(1L, "Mussarela", 8, 36F);
        Pizza p2 = new Pizza(2L, "Mussarela", 12, 67F);
        Pizza p3 = new Pizza(3L, "Margherita", 8, 37F);
        Pizza p4 = new Pizza(4L, "Margherita", 12, 70F);
        Pizza p5 = new Pizza(5L, "Caprese", 8, 40F);
        Pizza p6 = new Pizza(6L, "Caprese", 12, 77F);
        Pizza p7 = new Pizza(7L, "Três Queijos", 8,  47F);
        Pizza p8 = new Pizza(8L, "Três Queijos", 12,  83F);
        Pizza p9 = new Pizza(9L, "Quatro Queijos", 8, 50F);
        Pizza p10 = new Pizza(10L, "Quatro Queijos", 12, 83F);

        this.adicionaPizza(p1);
        this.adicionaPizza(p2);
        this.adicionaPizza(p3);
        this.adicionaPizza(p4);
        this.adicionaPizza(p5);
        this.adicionaPizza(p6);
        this.adicionaPizza(p7);
        this.adicionaPizza(p8);
        this.adicionaPizza(p9);
        this.adicionaPizza(p10);

        return this.pizzas;
    }

    public List<Sobremesa> getSobremessas(){
        Sobremesa s1 = new Sobremesa(1L, "Bolo", 5F);
        Sobremesa s2 = new Sobremesa(2L, "Pudim", 3.5F);

        this.adicionaSobremesa(s1);
        this.adicionaSobremesa(s2);

        return this.sobremesas;
    }
}
