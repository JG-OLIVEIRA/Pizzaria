package com.sensedia.sensezzaria.repository;

import com.sensedia.sensezzaria.entidades.Pedido;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;

public class PedidoRepository {

    public Pedido createPedido() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "INSERT INTO pedido (TOTAL) VALUE (?)";

        PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        myStat.setFloat(1,  (float) 0);

        myStat.executeUpdate();

        ResultSet result = myStat.getGeneratedKeys();

        Long id = null;
        if(result.next()){
            id = result.getLong(1);
        }

        connection.close();

        return new Pedido(id, (double) 0);
    }

    public Pedido getPedidoById(Long id) throws SQLException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "SELECT FROM pedido WHERE id = ?";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setDouble(1, id);

        myStat.execute();

        ResultSet result = myStat.getResultSet();

        connection.close();

        return new Pedido(result.getLong("id"), result.getDouble("total"));
    }

}
