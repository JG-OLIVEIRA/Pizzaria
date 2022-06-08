package com.sensedia.sensezzaria.funcionalidades;

import java.sql.SQLException;
import java.util.List;

import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.repository.BebidaRepository;
import com.sensedia.sensezzaria.repository.PizzaRepository;
import com.sensedia.sensezzaria.repository.SobremesaRepository;

public class Cardapio {

    PizzaRepository pizzaRepository = new PizzaRepository();

    BebidaRepository bebidaRepository = new BebidaRepository();

    SobremesaRepository sobremesaRepository = new SobremesaRepository();


    public List<Pizza> getPizzas() throws SQLException {
        return pizzaRepository.getPizzas();
    }

    public List<Bebida> getBebidas() throws SQLException {
        return bebidaRepository.getBebidas();
    }

    public List<Sobremesa> getSobremesas() throws SQLException {
        return sobremesaRepository.getSobremesas();
    }
}
