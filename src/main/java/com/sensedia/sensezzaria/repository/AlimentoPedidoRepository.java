package com.sensedia.sensezzaria.repository;
import com.sensedia.sensezzaria.entidades.*;
import com.sensedia.sensezzaria.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteAlimentoPedido(AlimentoPedido alimentoPedido) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query;
        PreparedStatement myStat;

        query = "DELETE FROM alimento_pedido WHERE id = ?";

        myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        myStat.setLong(1, alimentoPedido.getId());

        myStat.executeUpdate();
    }

    public AlimentoPedido getAlimentoPedidoByPedidoAndAlimento(Pedido pedido, Alimento alimento) throws  SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "";
        PreparedStatement myStat;


        if(alimento instanceof Bebida){
            query = "SELECT * FROM alimento_pedido WHERE id_bebida = ? AND id_pedido = ?";
        }

        if(alimento instanceof Pizza){
            query = "SELECT * FROM alimento_pedido WHERE id_pizza = ? AND id_pedido = ?";
        }

        if(alimento instanceof Sobremesa){
            query = "SELECT * FROM alimento_pedido WHERE id_sobremesa = ? AND id_pedido = ?";
        }

        myStat = connection.prepareStatement(query);

        myStat.setLong(1, alimento.getId());
        myStat.setLong(2, pedido.getId());

        myStat.execute();

        ResultSet result = myStat.getResultSet();

        AlimentoPedido alimentoPedido = new AlimentoPedido();

        while(result.next()){
            alimentoPedido.setId(result.getLong("ID"));
            alimentoPedido.setIdPedido(result.getLong("ID_PEDIDO"));
            alimentoPedido.setIdBebida(result.getLong("ID_BEBIDA"));
            alimentoPedido.setIdSobremesa(result.getLong("ID_SOBREMESA"));
            alimentoPedido.setIdPizza(result.getLong("ID_PIZZA"));
        }

        connection.close();

        return alimentoPedido;
    }

    public List<Bebida> getBebidasByPedido(Pedido pedido) throws SQLException {

        List<Bebida> bebidas = new ArrayList<>();

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "select * from alimento_pedido ap left join bebida b on (ap.id_bebida = b.id) where ap.id_pedido = ?;";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setDouble(1, pedido.getId());

        myStat.execute();

        ResultSet result = myStat.getResultSet();

        while(result.next()){
            Bebida bebida = new Bebida();

            Long id = result.getLong("ID_BEBIDA");
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

    public List<Pizza> getPizzasByPedido(Pedido pedido) throws SQLException {

        List<Pizza> pizzas = new ArrayList<>();

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "select * from alimento_pedido ap left join pizza p on (ap.id_pizza = p.id) where ap.id_pedido = ?;";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setDouble(1, pedido.getId());

        myStat.execute();

        ResultSet result = myStat.getResultSet();

        while(result.next()){
            Pizza pizza = new Pizza();

            Long id = result.getLong("ID_PIZZA");
            String sabor = result.getString("SABOR");
            Integer tamanho = result.getInt("TAMANHO");
            Float valor = result.getFloat("VALOR");

            pizza.setId(id);
            pizza.setSabor(sabor);
            pizza.setTamanho(tamanho);
            pizza.setValor(valor);

            pizzas.add(pizza);
        }

        return pizzas;
    }

    public List<Sobremesa> getSobremesasByPedido(Pedido pedido) throws SQLException {

        List<Sobremesa> sobremesas = new ArrayList<>();

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.criaConexao();

        String query = "select * from alimento_pedido ap left join sobremesa s on (ap.id_sobremesa = s.id) where ap.id_pedido = ?;";

        PreparedStatement myStat = connection.prepareStatement(query);

        myStat.setDouble(1, pedido.getId());

        myStat.execute();

        ResultSet result = myStat.getResultSet();

        while(result.next()){
            Sobremesa sobremesa = new Sobremesa();

            Long id = result.getLong("ID_SOBREMESA");
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
