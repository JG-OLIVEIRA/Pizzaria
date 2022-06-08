package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.*;
import com.sensedia.sensezzaria.repository.AlimentoPedidoRepository;

import java.sql.SQLException;
import java.util.List;

public class AlimentoPedidoService {

    AlimentoPedidoRepository alimentoPedidoRepository = new AlimentoPedidoRepository();

    public void addItensAoPedido(Pedido pedido){

        List<Alimento> alimentos = pedido.getAlimentos();

        alimentos.forEach(alimento -> {

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
        });

    }

}
