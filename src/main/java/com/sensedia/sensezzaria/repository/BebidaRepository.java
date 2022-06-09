package com.sensedia.sensezzaria.repository;

import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BebidaRepository {

    public Bebida createBebida(String nome, Float medida, Float valor) throws  SQLException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "INSERT INTO bebida (NOME, MEDIDA, VALOR) VALUE (?, ?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        myStat.setString(1, nome);
        myStat.setFloat(2, medida);
        myStat.setFloat(3,valor);

        myStat.execute();

        ResultSet result = myStat.getGeneratedKeys();

        Long id = null;
        if(result.next()){
            id = result.getLong(1);
        }

        connection.close();

        return new Bebida(id, nome, medida, valor );
    }

    public void deleteBebidaById(Integer id) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "DELETE FROM bebida WHERE id = ?";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setDouble(1, id);

        myStat.executeUpdate();

        connection.close();
    }

    public List<Bebida> getBebidas() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        Statement statement = connection.createStatement();

        statement
                .execute("SELECT ID, NOME, MEDIDA, VALOR FROM bebida");

        ResultSet result = statement.getResultSet();

        List<Bebida> bebidas = new ArrayList<>();

        while(result.next()){
            Bebida bebida = new Bebida();

            Long id = result.getLong("ID");
            String nome = result.getString("NOME");
            Float medida = result.getFloat("MEDIDA");
            Float valor = result.getFloat("VALOR");

            bebida.setId(id);
            bebida.setNome(nome);
            bebida.setMedida(medida);
            bebida.setValor(valor);

            bebidas.add(bebida);
        }

        connection.close();

        return bebidas;
    }



}
