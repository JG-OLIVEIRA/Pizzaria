package com.sensedia.sensezzaria.testes;
import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.repository.BebidaRepository;
import com.sensedia.sensezzaria.repository.PizzaRepository;
import com.sensedia.sensezzaria.repository.SobremesaRepository;

import java.sql.SQLException;
import java.util.List;

public class TestInsert {

    public static void main(String[] args){

        PizzaRepository pizzaRepository = new PizzaRepository();

        BebidaRepository bebidaRepository = new BebidaRepository();

        SobremesaRepository sobremesaRepository = new SobremesaRepository();

        List<Bebida> bebidas = List.of(
                new Bebida(1L, "Coca-coca", 0.25F, 2.5F),
                new Bebida(2L, "Coca-coca", 1F, 9F),
                new Bebida(3L, "Guaraná", 0.25F, 2.5F),
                new Bebida(4L, "Guaraná", 1F, 8.5F),
                new Bebida(5L, "Skol-Beats", 0.35F, 7F)
        );

        List<Pizza> pizzas = List.of(
                new Pizza(1L, "Mussarela", 8, 36F),
                new Pizza(2L, "Mussarela", 12, 67F),
                new Pizza(3L, "Margherita", 8, 37F),
                new Pizza(4L, "Margherita", 12, 70F),
                new Pizza(5L, "Caprese", 8, 40F),
                new Pizza(6L, "Caprese", 12, 77F),
                new Pizza(7L, "Três Queijos", 8,  47F),
                new Pizza(8L, "Três Queijos", 12,  83F),
                new Pizza(9L, "Quatro Queijos", 8, 50F),
                new Pizza(10L, "Quatro Queijos", 12, 83F)
        );

        List<Sobremesa> sobremesas = List.of(
                new Sobremesa(1L, "Bolo", 5F),
                new Sobremesa(2L, "Pudim", 3.5F)
        );

        pizzas.forEach(pizza -> {
            try {
                pizzaRepository.addPizza(pizza);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        sobremesas.forEach(sobremesa -> {
            try {
                sobremesaRepository.addSobremesa(sobremesa);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        bebidas.forEach(bebida -> {
            try {
                bebidaRepository.addBebida(bebida);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
