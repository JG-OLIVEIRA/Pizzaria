package com.sensedia.sensezzaria.repository;
import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaRepository {

    public List<Pizza> getPizzas() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        Statement statement = connection.createStatement();

        statement.execute("SELECT ID, SABOR, TAMANHO, VALOR FROM pizza");

        ResultSet result = statement.getResultSet();

        List<Pizza> pizzas = new ArrayList<>();

        while(result.next()){
            Pizza pizza = new Pizza();

            Long id = result.getLong("ID");
            String sabor = result.getString("SABOR");
            Integer tamanho = result.getInt("TAMANHO");
            Float valor = result.getFloat("VALOR");

            pizza.setId(id);
            pizza.setSabor(sabor);
            pizza.setTamanho(tamanho);
            pizza.setValor(valor);

            pizzas.add(pizza);
        }

        connection.close();

        return pizzas;
    }

    public void addPizza(Pizza pizza) throws  SQLException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "INSERT INTO pizza (SABOR, TAMANHO, VALOR) VALUE (?, ?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setString(1, pizza.getSabor());
        myStat.setFloat(2, pizza.getTamanho());
        myStat.setFloat(3, pizza.getValor());

        myStat.execute();

        connection.close();
    }

    public void deletePizzaById(Integer id) throws SQLException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "DELETE FROM pizza WHERE id = ?";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setInt(1, id);

        myStat.execute();

        connection.close();
    }
}
