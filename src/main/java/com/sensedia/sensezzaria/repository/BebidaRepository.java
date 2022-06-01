package com.sensedia.sensezzaria.repository;

import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BebidaRepository {

    public List<Bebida> getBebidas() throws SQLException {

        ConnectionFactory conexaoRepository = new ConnectionFactory();

        Connection connection = conexaoRepository.criaConexao();

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

    public void addBebida(Bebida bebida) throws  SQLException{

        ConnectionFactory conexaoRepository = new ConnectionFactory();

        Connection connection = conexaoRepository.criaConexao();

        String query = "INSERT INTO bebida (NOME, MEDIDA, VALOR) VALUE (?, ?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setString(1, bebida.getNome());
        myStat.setFloat(2, bebida.getMedida());
        myStat.setFloat(3, bebida.getValor());

        myStat.execute();

        connection.close();
    }
}
