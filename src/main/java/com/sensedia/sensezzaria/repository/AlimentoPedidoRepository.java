package com.sensedia.sensezzaria.repository;
import com.sensedia.sensezzaria.entidades.AlimentoPedido;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import javax.swing.plaf.TableHeaderUI;
import java.sql.*;

public class AlimentoPedidoRepository {

    public AlimentoPedido createAlimentoPedido(Long id_pedido, Long id_bebida, Long id_pizza, Long id_sobremesa) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "INSERT INTO alimento_pedido (ID_PEDIDO, ID_BEBIDA, ID_PIZZA, ID_SOBREMESA) VALUE (?, ?, ?, ?)";

        PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        if(id_bebida != null){
            myStat.setLong(1, id_pedido);
            myStat.setLong(2, id_bebida);
            myStat.setNull(3, 4);
            myStat.setNull(4, 4);
        }

        if(id_pizza != null){
            myStat.setLong(1, id_pedido);
            myStat.setNull(2, 4);
            myStat.setLong(3, id_pizza);
            myStat.setNull(4, 4);
        }

        if(id_sobremesa != null){
            myStat.setLong(1, id_pedido);
            myStat.setNull(2, 4);
            myStat.setNull(3, 4);
            myStat.setLong(4, id_sobremesa);
        }

        myStat.executeUpdate();

        ResultSet result = myStat.getGeneratedKeys();

        Long id = null;
        if(result.next()){
            id = result.getLong(1);
        }

        connection.close();

        return new AlimentoPedido(id, id_pedido, id_bebida, id_pizza, id_sobremesa);
    }
}
