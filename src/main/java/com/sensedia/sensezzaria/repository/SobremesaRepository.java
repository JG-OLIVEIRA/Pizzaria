package com.sensedia.sensezzaria.repository;

import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SobremesaRepository {

    public List<Sobremesa> getSobremesas() throws SQLException {

        ConnectionFactory conexaoRepository = new ConnectionFactory();

        Connection connection = conexaoRepository.criaConexao();

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

    public void addSobremesa(Sobremesa sobremesa) throws  SQLException{

        ConnectionFactory conexaoRepository = new ConnectionFactory();

        Connection connection = conexaoRepository.criaConexao();

        String query = "INSERT INTO sobremesa (NOME, VALOR) VALUE (?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setString(1, sobremesa.getNome());
        myStat.setFloat(2, sobremesa.getValor());

        myStat.execute();

        connection.close();
    }

}
