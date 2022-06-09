package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.repository.PizzaRepository;

import java.sql.SQLException;

public class PizzaService {

    PizzaRepository pizzaRepository = new PizzaRepository();

    public Pizza createPizza(String sabor, Integer tamanho, Float valor) throws SQLException {
        return pizzaRepository.createPizza(sabor, tamanho, valor);
    }
}
