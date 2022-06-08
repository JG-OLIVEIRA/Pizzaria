package com.sensedia.sensezzaria.repository;

import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SobremesaRepository {

    public Sobremesa createSobremesa(String nome, Float valor) throws  SQLException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "INSERT INTO sobremesa (NOME, VALOR) VALUE (?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        myStat.setString(1, nome);
        myStat.setFloat(2, valor);

        myStat.execute();

        ResultSet result = myStat.getGeneratedKeys();

        Long id = null;
        if(result.next()){
            id = result.getLong(1);
        }

        connection.close();

        return new Sobremesa(id, nome, valor);
    }

    public List<Sobremesa> getSobremesas() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        Statement statement = connection.createStatement();

        statement.execute("SELECT ID, NOME, VALOR FROM sobremesa");

        ResultSet result = statement.getResultSet();

        List<Sobremesa> sobremesas = new ArrayList<>();

        while(result.next()){
            Sobremesa sobremesa = new Sobremesa();

            Long id = result.getLong("ID");
            String nome = result.getString("NOME");
            Float valor = result.getFloat("VALOR");

            sobremesa.setId(id);
            sobremesa.setNome(nome);
            sobremesa.setValor(valor);

            sobremesas.add(sobremesa);
        }

        connection.close();

        return sobremesas;
    }

}
