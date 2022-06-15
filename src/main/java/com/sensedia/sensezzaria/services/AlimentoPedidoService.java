package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.*;
import com.sensedia.sensezzaria.repository.AlimentoPedidoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlimentoPedidoService {

    AlimentoPedidoRepository alimentoPedidoRepository = new AlimentoPedidoRepository();

    public void addItensAoPedido(Pedido pedido, Alimento alimento){

            try {

                if(alimento instanceof Pizza){
                    alimentoPedidoRepository.
                            createAlimentoPedido(pedido.getId(), null, alimento.getId(), null);
                }

                if(alimento instanceof Bebida){
                    alimentoPedidoRepository.
                            createAlimentoPedido(pedido.getId(), alimento.getId(), null, null);
                }

                if (alimento instanceof Sobremesa){
                    alimentoPedidoRepository.
                            createAlimentoPedido(pedido.getId(), null, null, alimento.getId());
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    public AlimentoPedido getAlimentoPedido(Pedido pedido, Alimento alimento) throws SQLException {
        return alimentoPedidoRepository.getAlimentoPedidoByPedidoAndAlimento(pedido, alimento);
    }

    public void deleteAlimentoPedido(AlimentoPedido alimentoPedido) throws SQLException {
        alimentoPedidoRepository.deleteAlimentoPedido(alimentoPedido);
    }

    public List<Alimento> getItensDoPedido(Pedido pedido) throws SQLException {

        List<Alimento> alimentos = new ArrayList<>();

        List<Bebida> bebidas = alimentoPedidoRepository.getBebidasByPedido(pedido);
        List<Pizza> pizzas = alimentoPedidoRepository.getPizzasByPedido(pedido);
        List<Sobremesa> sobremesas = alimentoPedidoRepository.getSobremesasByPedido(pedido);

        sobremesas.forEach(sobremesa -> {
                if(sobremesa.getNome() != null){
                    alimentos.add(sobremesa);
                }
            }
        );

        pizzas.forEach(pizza -> {
                    if(pizza.getSabor() != null){
                        alimentos.add(pizza);
                    }
                }
        );

        bebidas.forEach(bebida -> {
                    if(bebida.getNome() != null){
                        alimentos.add(bebida);
                    }
                }
        );

        return alimentos;
    }


}
